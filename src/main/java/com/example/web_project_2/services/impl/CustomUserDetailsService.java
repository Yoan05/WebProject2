package com.example.web_project_2.services.impl;

import com.example.web_project_2.models.entities.RoleEntity;
import com.example.web_project_2.models.entities.UserEntity;
import com.example.web_project_2.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(email)
                .map(CustomUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + "not found!"));
    }

    private static UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(CustomUserDetailsService::map).toList())
                .build();
    }

    private static GrantedAuthority map(RoleEntity roleEntity){
        return new SimpleGrantedAuthority("ROLE_" + roleEntity.getName().name());
    }
}
