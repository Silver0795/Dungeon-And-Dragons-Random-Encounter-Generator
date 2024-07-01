package com.oota.reg.services;

import com.oota.reg.entities.Luoghi;
import com.oota.reg.exceptions.ElementNotFound;
import com.oota.reg.repo.LuoghiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LuoghiService {

    @Autowired
    LuoghiRepo repo;


    public List<Luoghi> getAllLuoghi() {
        return repo.findAll();
    }


    public Luoghi getLuogoById(Long luogoId) {
       return repo.findById(luogoId).orElseThrow(
               ()-> new ElementNotFound("elemento non trovato"));
    }

    public Luoghi addLuogo(Luoghi luogo) {
        return repo.save(luogo);
    }

    public ResponseEntity<?> updateLuogo(Luoghi luogo) {

       Luoghi updatedLuogo = repo.findById(luogo.getId()).orElse(null);

       if (updatedLuogo != null){
           return new ResponseEntity<>(repo.save(luogo), HttpStatus.OK);
       }
         return new ResponseEntity<>("Oggetto non trovato", HttpStatus.BAD_REQUEST);

    }

    public void deleteLuogo(Long luogoId) {
        repo.deleteById(luogoId);
    }
}
