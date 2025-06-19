package com.aplication.deliverymatch1.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class Filter implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String redirectUrl = "/home";

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();

            if (role.equals("ROLE_ADMIN")) {
                redirectUrl = "/admin/dashboard";
                break;
            } else if (role.equals("ROLE_Conducteur")) {
                redirectUrl = "/conducteur/dashboard";
                break;
            } else if (role.equals("ROLE_Expediteur")) {
                redirectUrl = "/expediteur/dashboard";
                break;
            } else if (role.equals("ROLE_USER")) {
                redirectUrl = "/user/dashboard";
                break;
            }
        }

        response.sendRedirect(redirectUrl);
    }
}

