package com.libbioproject.service;

import com.libbioproject.domain.User;
import com.libbioproject.exception.ResourceNotFound;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new ResourceNotFound(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE_EMAIL, email)));
    }
}
