package com.libbioproject.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
/**
 * Utils for security function that can be used in service layer
 * 6. class to implement
 */
public class SecurityUtils {

    /**
     * private constructor not to initialize any SecurityUtils object,
     * since the method that will be called getCurrentUserLogin() is static.
     */
    private SecurityUtils(){

    }

    /**
     * helper method to fetch user information from SECURITY CONTEXT.
     * @return
     */
    public static Optional<String>getCurrentUserLogin(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return Optional.ofNullable(extractPrincipal(authentication));
    }

    /**
     * authentication.getPrincipal() -> the identity of the principal being authenticated.
     * In case of an authentication request with username and password, this would be the username.
     */
    private static String extractPrincipal (Authentication authentication){
        if(authentication==null){
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails securedUser = (UserDetails) authentication.getPrincipal();
            return securedUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }




}
