package com.rentcar.backend.security;

import com.rentcar.backend.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {
    private final Long id;
    private final String username; // CNP
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean active;

    public CustomUserDetails(User u, Collection<? extends GrantedAuthority> auth) {
        this.id = u.getId();
        this.username = u.getCnp();
        this.password = u.getPassword();
        this.authorities = auth;
        this.active = u.isActive();
    }

    @Override public boolean isAccountNonExpired()     { return active; }
    @Override public boolean isAccountNonLocked()      { return active; }
    @Override public boolean isCredentialsNonExpired() { return active; }
    @Override public boolean isEnabled()               { return active; }
}
