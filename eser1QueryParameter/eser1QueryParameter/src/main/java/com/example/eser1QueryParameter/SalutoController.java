package com.example.eser1QueryParameter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SalutoController {

    @RequestMapping(method = RequestMethod.GET, path = "/ciao")
    public String saluto (@RequestParam String nome, @RequestParam String provincia) {
        return "Ciao " + nome + ", " + "com'è il tempo in " + provincia + "?";
    }

}
