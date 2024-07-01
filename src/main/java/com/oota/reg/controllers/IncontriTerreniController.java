package com.oota.reg.controllers;


import com.oota.reg.entities.IncontriTerreni;
import com.oota.reg.entities.Luoghi;
import com.oota.reg.services.IncontriTerreniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incontri-terreni")
@CrossOrigin("*")
public class IncontriTerreniController {

    @Autowired
    IncontriTerreniService service;

    @GetMapping("/all")
    public List<IncontriTerreni> getAllIncontri(){
        return service.getAllTerreni();
    }

    @GetMapping("/{incontroId}")
    public ResponseEntity<IncontriTerreni> getLuogoById(@PathVariable Long incontroId){
        IncontriTerreni incontro = service.getLuogoById(incontroId);
        return new ResponseEntity<>(incontro, HttpStatus.OK);
    }

    @GetMapping("/idLuogo/{idLuogo}")
    public List<IncontriTerreni> getIncontroByIdLuogo(@PathVariable Luoghi idLuogo){
        return service.getLuoghibyIdLuogo(idLuogo);
    }


    @PostMapping("/add")
    public ResponseEntity<IncontriTerreni> addIncontro(@RequestBody IncontriTerreni incontro){
        IncontriTerreni newIncontro= service.addIncontro(incontro);
        return new ResponseEntity<>(newIncontro,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateIncontro(@RequestBody IncontriTerreni incontro){
        return service.updateLuogo(incontro);
    }

    @DeleteMapping("/delete/{incontroId}")
    public void deleteLuogo(@PathVariable Long incontroId){
        service.deleteIncontro(incontroId);
    }


}
