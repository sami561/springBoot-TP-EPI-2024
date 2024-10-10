package com.sami.medicalapp2025.service;

import com.sami.medicalapp2025.entities.Patient;
import com.sami.medicalapp2025.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePatient implements  IServicePatient {
    public final PatientRepository patientRepository;
    @Override
    public Patient createPatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Patient findPatientById(int id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Patient a) {
        return patientRepository.save(a);
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
