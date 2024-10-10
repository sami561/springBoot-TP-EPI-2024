package com.sami.medicalapp2025.service;

import com.sami.medicalapp2025.entities.Medecin;
import com.sami.medicalapp2025.entities.Patient;

import java.util.List;

public interface IServicePatient {
    public Patient createPatient(Patient p);
    public  Patient findPatientById(int id);
    public List<Patient> findAllPatient();
    public Patient updatePatient(Patient a);
    public void deletePatient(int id);
}
