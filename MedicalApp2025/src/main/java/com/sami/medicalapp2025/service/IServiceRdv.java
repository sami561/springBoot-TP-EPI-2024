package com.sami.medicalapp2025.service;

import com.sami.medicalapp2025.entities.Patient;
import com.sami.medicalapp2025.entities.Rdv;

import java.util.List;

public interface IServiceRdv {
    public Rdv createRdv(Rdv p);
    public  Rdv findRdvById(int id);
    public List<Rdv> findAllRdv();
    public Rdv updateRdv(Rdv a);
    public void deleteRdv(int id);
}
