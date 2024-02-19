package com.poc.msproductos.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductosController {
    @GetMapping("/protected")
    public String protectedEndpoint(@AuthenticationPrincipal Jwt jwt) {
        // Aquí puedes acceder al JWT decodificado
        System.out.println("JWT Claims: " + jwt.getClaims());
        System.out.println("JWT Token: " + jwt.getTokenValue());
        
        return "algo: "+jwt.getTokenValue();
    }
    
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Este contenido es público";
    }
}
