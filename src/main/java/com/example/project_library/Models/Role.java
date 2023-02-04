package com.example.project_library.Models;
import org.springframework.security.core.GrantedAuthority;
public enum Role implements GrantedAuthority{
    LIBRARIAN, ADMIN, MANAGER;
    @Override
    public String getAuthority() {
        return name();
    }
}
