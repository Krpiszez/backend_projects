package com.libbioproject.service;

import com.libbioproject.domain.Role;
import com.libbioproject.domain.User;
import com.libbioproject.domain.enums.RoleType;
import com.libbioproject.dto.request.RegisterRequest;
import com.libbioproject.exception.ConflictException;
import com.libbioproject.exception.ResourceNotFound;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new ResourceNotFound(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE_EMAIL, email)));
    }

    public void registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, registerRequest.getEmail()));
        }
        String encodedPassword = passwordEncoder.encode(registerRequest.getEmail());
        Role role = roleService.findByType(RoleType.ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setAddress(registerRequest.getAddress());
        user.setZipCode(registerRequest.getZipCode());
        user.setPassword(encodedPassword);
        user.setRoles(roles);
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        userRepository.save(user);
    }
}
