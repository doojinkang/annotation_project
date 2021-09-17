package springlike.controller;

import springlike.annotation.Controller;

@Controller
public class HelloController {
    public static void handle() {
        System.out.println("Hello Controller");
    }
}
