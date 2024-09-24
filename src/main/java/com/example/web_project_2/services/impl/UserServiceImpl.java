package com.example.web_project_2.services.impl;

import com.example.web_project_2.models.dtos.UserRegisterDto;
import com.example.web_project_2.models.entities.UserEntity;
import com.example.web_project_2.repositories.UserRepository;
import com.example.web_project_2.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final PasswordEncoder pe;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, PasswordEncoder pe) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.pe = pe;
    }

    @Override
    public boolean register(UserRegisterDto userRegisterDto) {
        if (!checkUserRegisterDto(userRegisterDto)){
            return false;
        }
        UserEntity user = mapper.map(userRegisterDto, UserEntity.class);
        user.setPassword(pe.encode(user.getPassword()));
        this.userRepository.saveAndFlush(user);
        return true;
    }

    @Override
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return userRepository.findByEmail(currentUserName).get();
    }

    private boolean checkUserRegisterDto(UserRegisterDto userRegisterDto) {
        if (userRegisterDto.getEmail().isBlank()){
            return false;
        }
        return true;
    }
}
