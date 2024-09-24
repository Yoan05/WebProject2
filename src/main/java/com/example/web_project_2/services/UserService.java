package com.example.web_project_2.services;

import com.example.web_project_2.models.dtos.UserRegisterDto;
import com.example.web_project_2.models.entities.UserEntity;

public interface UserService {
    boolean register(UserRegisterDto userRegisterDto);

    UserEntity getCurrentUser();
}
