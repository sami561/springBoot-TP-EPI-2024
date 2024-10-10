package com.sami.medicalapp2025.repository;

import com.sami.medicalapp2025.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Integer> {
}
