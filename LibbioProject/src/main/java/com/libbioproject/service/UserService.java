package com.libbioproject.service;

import com.libbioproject.domain.Role;
import com.libbioproject.domain.User;
import com.libbioproject.domain.enums.RoleType;
import com.libbioproject.dto.UserDTO;
import com.libbioproject.dto.request.RegisterRequest;
import com.libbioproject.exception.BadRequestException;
import com.libbioproject.exception.ConflictException;
import com.libbioproject.exception.ResourceNotFound;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.mapper.UserMapper;
import com.libbioproject.repository.UserRepository;
import com.libbioproject.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, RoleService roleService, @Lazy PasswordEncoder passwordEncoder,
                       UserMapper userMapper){
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new ResourceNotFound(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE_EMAIL, email)));
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE,id)));
    }
    public static void noPermittedBuiltIn(User user){
        if (user.getBuiltIn()){
            throw new BadRequestException(ErrorMessage.NOT_PERMITTED_METHOD_MESSAGE);
        }
    }
    public UserDTO getPrincipal() {
        User currentUser = getCurrentUser();
        return userMapper.userToDTO(currentUser);
    }
    private User getCurrentUser() {
        String email = SecurityUtils.getCurrentUser().orElseThrow(
                ()-> new ResourceNotFound(ErrorMessage.PRINCIPAL_NOT_FOUND_MESSAGE));
        return getUserByEmail(email);
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

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.userListToDTOList(userList);
    }
    public UserDTO getUserDTOById(Long id) {
        User user = getUserById(id);
        return userMapper.userToDTO(user);
    }
    public void deleteCurrentUser() {
        User user = getCurrentUser();
        noPermittedBuiltIn(user);
        userRepository.delete(user);
    }

    public void deleteUserById(Long id) {
        User user = getUserById(id);
        noPermittedBuiltIn(user);
        userRepository.deleteById(user.getId());
    }
}
