package com.sami.medicalapp2025.service;

import com.sami.medicalapp2025.entities.Medecin;

import java.util.List;

public interface IServiceMedecin {
    public Medecin createMedecin(Medecin a);
    public Medecin findMedecinById(int id);
    public List<Medecin> findAllMedecins() ;

    public Medecin updateMedecin(Medecin a);
    public void deleteMedecin(int id);
}
