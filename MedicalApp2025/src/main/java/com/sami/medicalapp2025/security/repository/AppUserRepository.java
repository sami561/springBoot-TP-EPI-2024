package com.sami.medicalapp2025.security.repository;

import com.sami.medicalapp2025.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}
