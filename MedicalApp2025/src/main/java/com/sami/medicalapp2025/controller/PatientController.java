package com.sami.medicalapp2025.controller;

import com.sami.medicalapp2025.entities.Medecin;
import com.sami.medicalapp2025.entities.Patient;
import com.sami.medicalapp2025.service.IServiceMedecin;
import com.sami.medicalapp2025.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    private  final IServicePatient iServicePatient;
    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> findPatient(@PathVariable("id") int id){
        Patient d = iServicePatient.findPatientById(id);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Patient>addPatient(@RequestBody Patient d){
        Patient dr = iServicePatient.createPatient(d);
        return ResponseEntity.ok(dr);
    }
    @PutMapping("/update")
    public ResponseEntity<Patient>updatePatient(@RequestBody Patient d){
        Patient dr = iServicePatient.updatePatient(d);
        return ResponseEntity.ok(dr);
    }
    @DeleteMapping("/delete/{id}")
    public void  deletePatient(@PathVariable("id") int id){
    iServicePatient.deletePatient(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> findAll(){
        return ResponseEntity.ok(iServicePatient.findAllPatient());
    }

}
