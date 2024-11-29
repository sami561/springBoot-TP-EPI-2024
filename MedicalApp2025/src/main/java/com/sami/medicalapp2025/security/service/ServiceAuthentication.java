package com.sami.medicalapp2025.security.service;

import com.sami.medicalapp2025.security.entities.AppRole;
import com.sami.medicalapp2025.security.entities.AppUser;
import com.sami.medicalapp2025.security.repository.AppRoleRepository;
import com.sami.medicalapp2025.security.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServiceAuthentication implements  IServiceAuthentication{
    public final AppRoleRepository appRoleRepository;
    public  final AppUserRepository appUserRepository;
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public AppUser createAppUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        return appUserRepository.save(appUser);


    }

    @Override
    public AppRole createAppRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRole(role);
        user.getRoles().add(appRole);
        appUserRepository.save(user);
    }
    @Override
    public AppUser loadUserByUsername(String username) {
        return
                appUserRepository.findByUsername(username);
    }
}
