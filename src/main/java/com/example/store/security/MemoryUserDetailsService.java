package com.example.store.security;

/* ===== IMPORTS ===== */
import com.example.store.model.User;
import com.example.store.repository.MemoryDB;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
/* =================== */

@Service
public class MemoryUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = MemoryDB.users.stream()
                .filter(u -> u.username.equals(username))
                .findFirst()
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.username,
                user.password,
                List.of(new SimpleGrantedAuthority("ROLE_" + user.role))
        );
    }
}
