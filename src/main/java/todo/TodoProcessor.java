package todo;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("todo.Todo")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TodoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();

        for (TypeElement typeElement: annotations) {
            for (Element element: roundEnv.getElementsAnnotatedWith(typeElement)) {
                Todo todo = element.getAnnotation(Todo.class);
                messager.printMessage(Diagnostic.Kind.WARNING, "TODO : " + todo.value() + " at " + element);
            }
        }

        return true;
    }
}
