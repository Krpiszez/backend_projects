package com.libbioproject.dto;

import com.libbioproject.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String zipCode;
    private Boolean builtIn;
    private Set<String> roles;
    // ask the UserMapperImpl created by itself ?
    public void setRoles (Set<Role> roles){
        Set<String> roleStr = new HashSet<>();
        roles.forEach(role -> roleStr.add(role.getType().getName()));
        this.roles = roleStr;
    }


}
