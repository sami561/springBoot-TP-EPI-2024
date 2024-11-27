package com.sami.medicalapp2025.security.service;

import com.sami.medicalapp2025.security.entities.AppRole;
import com.sami.medicalapp2025.security.entities.AppUser;

public interface IServiceAuthentication {
    public AppUser createAppUser(AppUser appUser);
    public AppRole createAppRole(AppRole appRole);
    public void addRoleToUser(String username, String role);
    public AppUser loadUserByUsername(String username);

}
