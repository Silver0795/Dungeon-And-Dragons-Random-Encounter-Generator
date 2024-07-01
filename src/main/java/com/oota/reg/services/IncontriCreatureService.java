package com.oota.reg.services;

import com.oota.reg.entities.IncontriCreature;
import com.oota.reg.entities.IncontriTerreni;
import com.oota.reg.entities.Luoghi;
import com.oota.reg.exceptions.ElementNotFound;
import com.oota.reg.repo.IncontriCreatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncontriCreatureService {

    @Autowired
    IncontriCreatureRepo repo;

    public List<IncontriCreature> getAllTerreni(){
        return repo.findAll();
    }

    public IncontriCreature getLuogoById(Long id){
        return repo.findById(id).orElseThrow(()->new ElementNotFound("elemento non trovato"));
    }

    public IncontriCreature addIncontro(IncontriCreature incontro){
        return repo.save(incontro);
    }

    public ResponseEntity<?> updateLuogo(IncontriCreature incontro) {

        IncontriCreature updatedTerreno = repo.findById(incontro.getId()).orElse(null);

        if (updatedTerreno != null){
            return new ResponseEntity<>(repo.save(incontro), HttpStatus.OK);
        }
        return new ResponseEntity<>("Oggetto non trovato", HttpStatus.BAD_REQUEST);

    }

    public void deleteIncontro(Long id){
        repo.deleteById(id);
    }

    public List<IncontriCreature> getLuoghibyIdLuogo(Luoghi id){
        return repo.findAllByidLuogo(id);
    }
}
