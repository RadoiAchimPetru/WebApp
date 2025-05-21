package com.rentcar.backend.security;

import com.rentcar.backend.model.User;
import com.rentcar.backend.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepo;

    public UserDetailsServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String cnp) throws UsernameNotFoundException {
        User u = userRepo.findByCnp(cnp)
                .orElseThrow(() -> new UsernameNotFoundException("User nu a fost găsit"));
        var auth = List.of(new SimpleGrantedAuthority("ROLE_" + u.getRole()));
        return new CustomUserDetails(u, auth);
    }
}
