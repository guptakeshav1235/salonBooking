package com.keshav.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @GetMapping
    public String homeControllerHandler(){
        return "salon microService is running";
    }
}
