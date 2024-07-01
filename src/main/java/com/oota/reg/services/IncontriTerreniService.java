package com.oota.reg.services;

import com.oota.reg.entities.IncontriTerreni;
import com.oota.reg.entities.Luoghi;
import com.oota.reg.exceptions.ElementNotFound;
import com.oota.reg.repo.IncontriTerreniRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncontriTerreniService {

    @Autowired
    IncontriTerreniRepo repo;

    public List<IncontriTerreni> getAllTerreni(){
        return repo.findAll();
    }

    public IncontriTerreni getLuogoById(Long id){
        return repo.findById(id).orElseThrow(()->new ElementNotFound("elemento non trovato"));
    }

    public IncontriTerreni addIncontro(IncontriTerreni incontro){
        return repo.save(incontro);
    }

    public ResponseEntity<?> updateLuogo(IncontriTerreni incontro) {

        IncontriTerreni updatedTerreno = repo.findById(incontro.getId()).orElse(null);

        if (updatedTerreno != null){
            return new ResponseEntity<>(repo.save(incontro), HttpStatus.OK);
        }
        return new ResponseEntity<>("Oggetto non trovato", HttpStatus.BAD_REQUEST);

    }

    public void deleteIncontro(Long id){
         repo.deleteById(id);
    }

    public List<IncontriTerreni> getLuoghibyIdLuogo(Luoghi id){
       return repo.findAllByidLuogo(id);
    }

}
