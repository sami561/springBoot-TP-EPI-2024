package com.sami.medicalapp2025.controller;

import com.sami.medicalapp2025.entities.Medecin;
import com.sami.medicalapp2025.entities.Rdv;
import com.sami.medicalapp2025.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/rdv")
@AllArgsConstructor

public class RdvController {
    private final IServiceRdv iServiceRdv;
    @GetMapping("/find/{id}")
    public ResponseEntity<Rdv> findMedecin(@PathVariable("id") int id){
        Rdv d = iServiceRdv.findRdvById(id);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Object>addRdv(@RequestBody Rdv d){
        Rdv dr = iServiceRdv.createRdv(d);
        if(dr!= null)
            return new ResponseEntity<>(dr, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("le rdv est deja reserver ",HttpStatus.CONFLICT);

    }
    @PutMapping("/update")
    public ResponseEntity<Rdv>updateRdv(@RequestBody Rdv d){
        Rdv dr = iServiceRdv.updateRdv(d);
        return ResponseEntity.ok(dr);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteDoctor(@PathVariable("id") int id){
       iServiceRdv.deleteRdv(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Rdv>> findAll(){
        return ResponseEntity.ok(iServiceRdv.findAllRdv());
    }


}
