package com.example.eser3ControllerGetPost.controllers;

import com.example.eser3ControllerGetPost.services.SayNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @Autowired
    private SayNameService sayNameService;

    @GetMapping("/name")
    public String getName(){
        return sayNameService.sayName();
    }

    @PostMapping("/name")
    public String reversedName (@RequestParam String name){
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
    }
}
