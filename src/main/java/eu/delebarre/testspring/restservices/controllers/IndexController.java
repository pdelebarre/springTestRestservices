package eu.delebarre.testspring.restservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/oups")
    public String oupsHandler() {
        return "notimplemented";
    }
}