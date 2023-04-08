package com.libbioproject.service;

import com.libbioproject.domain.Role;
import com.libbioproject.domain.enums.RoleType;
import com.libbioproject.exception.ResourceNotFoundException;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByType(RoleType roleType){
        return roleRepository.findByType(roleType)
                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.ROLE_NOT_FOUND_EXCEPTION, roleType)));
    }

}
