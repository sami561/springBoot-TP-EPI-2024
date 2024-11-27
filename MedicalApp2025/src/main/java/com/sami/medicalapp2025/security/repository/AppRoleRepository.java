package com.sami.medicalapp2025.security.repository;

import com.sami.medicalapp2025.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Integer> {
    AppRole findByRole(String role);
}
