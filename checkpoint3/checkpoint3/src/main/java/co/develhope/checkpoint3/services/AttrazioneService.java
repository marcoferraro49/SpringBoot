package co.develhope.checkpoint3.services;

import co.develhope.checkpoint3.entities.Attrazione;
import co.develhope.checkpoint3.repositories.AttrazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttrazioneService {

    @Autowired
    AttrazioneRepo attrazioneRepo;

    public Attrazione creaAttrazione(Attrazione attrazione){
        return attrazioneRepo.save(attrazione);
    }

    public List<Attrazione> getAllAttrazione(){
        return attrazioneRepo.findAll();
    }

    public Attrazione getAttrazionePerId(long id){
        return attrazioneRepo.findById(id).orElse(null);
    }

    public Attrazione aggiornaAttrazione(long id, Attrazione attrazione){
        Attrazione attrazione1 = attrazioneRepo.findById(id).orElse(null);
        if (attrazione1 != null) {
            attrazione1.setNome(attrazione.getNome());
            attrazione1.setTipo(attrazione.getTipo());
            attrazione1.setDurata(attrazione.getDurata());
            attrazione1.setAltezzaMin(attrazione.getAltezzaMin());
            return attrazioneRepo.save(attrazione1);
        }
        return null;
    }

    public void cancellaAttrazionePerId(long id){
        attrazioneRepo.deleteById(id);
    }
}
