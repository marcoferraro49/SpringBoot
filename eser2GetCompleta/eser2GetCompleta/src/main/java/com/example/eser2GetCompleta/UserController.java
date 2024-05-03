package com.example.eser2GetCompleta;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class UserController {

    @GetMapping(path = "/ciao/Lombardia")
    public User ciao (@RequestParam String nome) {
        return new User(nome, "Lombardia");
    }
}
