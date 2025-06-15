package com.project.uber.uberApp.dto;

import com.project.uber.uberApp.enitities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;

    private Set<Role> roles;

}
