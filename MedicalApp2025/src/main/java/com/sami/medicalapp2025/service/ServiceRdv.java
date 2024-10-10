package com.sami.medicalapp2025.service;

import com.sami.medicalapp2025.entities.Rdv;
import com.sami.medicalapp2025.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv{
    public final RdvRepository rdvRepository;


    @Override
    public Rdv createRdv(Rdv p) {
        return  rdvRepository.save(p);
    }

    @Override
    public Rdv findRdvById(int id) {
        return  rdvRepository.findById(id).get() ;
    }

    @Override
    public List<Rdv> findAllRdv() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv updateRdv(Rdv a) {
        return rdvRepository.save(a);
    }

    @Override
    public void deleteRdv(int id) {
        rdvRepository.deleteById(id);
    }
}
