package it.develhope.eser5ControllerConCors.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class NameController {

    @CrossOrigin(origins = {"http://localhost:8080"})
    @GetMapping("/name")
    public String getName (@RequestParam String name) {
        return name;
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @PostMapping("/name/reverse")
    public String getReversedName (@RequestParam String name) {
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
    }
}
