package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {
    @GetMapping
    @ResponseBody
    public String hello() {

        return "Hello, Spring!";

    }

    // at hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {

        return "Goodbye, Spring!";

    }

    // Handles request of the form /hello?name=LaunchCode

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {

        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";

    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {

        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";

    }

    @GetMapping("form")
    public String helloForm() {

        return "form";

    }
    @GetMapping("hello-names")
    public String helloNames(Model model) {

        List<String> names = new ArrayList<>();

        names.add("Chuck");
        names.add("Bob");
        names.add("Grace");

        model.addAttribute("names", names);

        return "hello-list";

    }

}
