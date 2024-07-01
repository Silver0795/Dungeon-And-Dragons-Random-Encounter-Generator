package com.oota.reg.controllers;

import com.oota.reg.entities.IncontriCreature;
import com.oota.reg.entities.Luoghi;
import com.oota.reg.services.IncontriCreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incontri-creature")
@CrossOrigin("*")
public class IncontriCreatureController {

    @Autowired
    IncontriCreatureService service;

    @GetMapping("/all")
    public List<IncontriCreature> getAllIncontri(){
        return service.getAllTerreni();
    }

    @GetMapping("/{incontroId}")
    public ResponseEntity<IncontriCreature> getLuogoById(@PathVariable Long incontroId){
        IncontriCreature incontro = service.getLuogoById(incontroId);
        return new ResponseEntity<>(incontro, HttpStatus.OK);
    }

    @GetMapping("/idLuogo/{idLuogo}")
    public List<IncontriCreature> getIncontroByIdLuogo(@PathVariable Luoghi idLuogo){
        return service.getLuoghibyIdLuogo(idLuogo);
    }


    @PostMapping("/add")
    public ResponseEntity<IncontriCreature> addIncontro(@RequestBody IncontriCreature incontro){
        IncontriCreature newIncontro= service.addIncontro(incontro);
        return new ResponseEntity<>(newIncontro,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateIncontro(@RequestBody IncontriCreature incontro){
        return service.updateLuogo(incontro);
    }

    @DeleteMapping("/delete/{incontroId}")
    public void deleteLuogo(@PathVariable Long incontroId){
        service.deleteIncontro(incontroId);
    }
}
