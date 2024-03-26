package com.vizhu.vizhu.service;

import com.vizhu.vizhu.repo.jpa.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Log4j
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = clientRepository
                .findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        var role = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        if (user.getLogin().contains("admin")) {
            role.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // TODO: 22/03/24 delete for prod
        }
        return new User(user.getUsername(), user.getPassword(), role);
    }
}
