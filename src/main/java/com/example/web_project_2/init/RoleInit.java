package com.example.web_project_2.init;

import com.example.web_project_2.models.entities.RoleEntity;
import com.example.web_project_2.models.entities.enums.RolesEnum;
import com.example.web_project_2.repositories.RoleRepository;
import com.example.web_project_2.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RoleInit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findAll().isEmpty()){
            List<RoleEntity> list = new ArrayList<>();
            Arrays.stream(RolesEnum.values()).forEach(r -> {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setName(r);
                list.add(roleEntity);
            });
            roleRepository.saveAll(list);
        }
    }
}
