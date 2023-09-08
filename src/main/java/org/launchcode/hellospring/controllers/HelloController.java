package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + name + "!";

    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {

        return "Hello, " + name + "!";

    }

    @GetMapping("form")
    public String helloForm() {

        return "form";

    }

}
