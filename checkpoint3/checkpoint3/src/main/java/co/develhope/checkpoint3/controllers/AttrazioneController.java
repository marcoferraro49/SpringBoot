package co.develhope.checkpoint3.controllers;

import co.develhope.checkpoint3.entities.Attrazione;
import co.develhope.checkpoint3.services.AttrazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attrazioni")
public class AttrazioneController {

    @Autowired
    AttrazioneService attrazioneService;

    @PostMapping
    public Attrazione creaAttrazione(@RequestBody Attrazione attrazione){
        return attrazioneService.creaAttrazione(attrazione);
    }

    @GetMapping
    public List<Attrazione> getAll(){
        return attrazioneService.getAllAttrazione();
    }

    @GetMapping("/{id}")
    public Attrazione getAttrazionePerId(@PathVariable long id){
        return attrazioneService.getAttrazionePerId(id);
    }
}
