package com.example.web_project_2.models.entities;

import com.example.web_project_2.models.entities.enums.RolesEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private RolesEnum name;

    public RolesEnum getName() {
        return name;
    }

    public void setName(RolesEnum name) {
        this.name = name;
    }
}
