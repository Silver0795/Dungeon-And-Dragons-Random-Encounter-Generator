package com.oota.reg.controllers;


import com.oota.reg.entities.Luoghi;
import com.oota.reg.services.LuoghiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/luoghi")
@CrossOrigin("*")
public class LuoghiController {

    @Autowired
    LuoghiService service;

    @GetMapping("/all")
    public ResponseEntity<List<Luoghi> > getAllLuoghi(){
        List<Luoghi> allLuoghi =service.getAllLuoghi();
        return new ResponseEntity<>(allLuoghi, HttpStatus.OK);

    }

    @GetMapping("/{luogoId}")
    public ResponseEntity<Luoghi> getLuogoById(@PathVariable Long luogoId){
        Luoghi luogo = service.getLuogoById(luogoId);
        return new ResponseEntity<>(luogo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Luoghi> addLuogo(@RequestBody Luoghi luogo){
        Luoghi newLuogo= service.addLuogo(luogo);
        return new ResponseEntity<>(newLuogo,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateLuogo(@RequestBody Luoghi luogo){
       return service.updateLuogo(luogo);
    }

    @DeleteMapping("/delete/{luogoId}")
    public void deleteLuogo(@PathVariable Long luogoId){
        service.deleteLuogo(luogoId);
    }
}
