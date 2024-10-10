package com.sami.medicalapp2025.repository;

import com.sami.medicalapp2025.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface RdvRepository extends JpaRepository<Rdv,Integer> {
    Rdv findByPatientIdAndDateRdv(int id, LocalDateTime ldt);
    Rdv findByMedecinIdAndDateRdv(int id,LocalDateTime ldt);
}
