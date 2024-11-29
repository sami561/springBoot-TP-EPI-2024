package com.sami.medicalapp2025.controller;

import com.sami.medicalapp2025.security.entities.AppRole;
import com.sami.medicalapp2025.security.entities.AppUser;
import com.sami.medicalapp2025.security.service.IServiceAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final  IServiceAuthentication iServiceAuthentication;
     private final JwtEncoder jwtEncoder;
    private final AuthenticationManager authenticationManager;
    @PostMapping("/addRole")
    public ResponseEntity<AppRole> addRole(@RequestBody AppRole ap){
        AppRole ApR =iServiceAuthentication.createAppRole(ap);
        return ResponseEntity.ok(ApR);
    }
    @PostMapping("/addUser")
    public ResponseEntity<AppUser> addUser (@RequestBody AppUser au){
        AppUser apu =iServiceAuthentication.createAppUser(au);
        return ResponseEntity.ok(apu);
    }
    @PostMapping("/addRoleToUser")
    public ResponseEntity<String> addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        iServiceAuthentication.addRoleToUser(username, roleName);
        return ResponseEntity.ok("Role " + roleName + " has been added to user " + username);
    }



    @GetMapping("/profile")
    public Authentication profile(Authentication authentication){
        return authentication;
    }

    @PostMapping("/login")
    public Map<String, String> login(String username , String password){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );
        String scope = authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
        Instant instant = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(10, ChronoUnit.MINUTES))
                .subject(username)
                .claim("scope",scope)
                .build();
        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),
                jwtClaimsSet
        );
        String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
        return Map.of("access-token",jwt);
    }

}
