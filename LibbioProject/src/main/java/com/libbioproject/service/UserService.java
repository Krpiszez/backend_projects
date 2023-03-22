package com.libbioproject.service;

import com.libbioproject.domain.Role;
import com.libbioproject.domain.User;
import com.libbioproject.domain.enums.RoleType;
import com.libbioproject.dto.UserDTO;
import com.libbioproject.dto.request.AdminUserUpdateRequest;
import com.libbioproject.dto.request.RegisterRequest;
import com.libbioproject.dto.request.UpdateRequest;
import com.libbioproject.dto.request.UserUpdateRequest;
import com.libbioproject.exception.BadRequestException;
import com.libbioproject.exception.ConflictException;
import com.libbioproject.exception.ResourceNotFound;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.mapper.UserMapper;
import com.libbioproject.repository.UserRepository;
import com.libbioproject.security.SecurityUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private Page<UserDTO> pageUserToDTO(Page<User> userPage){
        return userPage.map(user -> userMapper.userToDTO(user));
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
    private static void canNotUpdatedEmailConfliction(UpdateRequest updateRequest, User currentUser, boolean emailExist) {
        if (emailExist && !currentUser.getEmail().equals(updateRequest.getEmail())){
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, currentUser.getEmail()));
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
    private Set<Role> convertRoles(Set<String> strRoles){
        Set<Role> roles = new HashSet<>();
        if (strRoles == null){
            Role userRole = roleService.findByType(RoleType.ROLE_CUSTOMER);
            roles.add(userRole);
        } else{
            strRoles.forEach(roleStr -> {
                if (roleStr.equals(RoleType.ROLE_ADMIN.getName())){
                    Role roleAdmin = roleService.findByType(RoleType.ROLE_ADMIN);
                    roles.add(roleAdmin);
                } else {
                    Role roleUser = roleService.findByType(RoleType.ROLE_CUSTOMER);
                    roles.add(roleUser);
                }
            });
        }
        return roles;
    }


    public void registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, registerRequest.getEmail()));
        }
        String encodedPassword = passwordEncoder.encode(registerRequest.getEmail());
        Role role = roleService.findByType(RoleType.ROLE_CUSTOMER);
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
    public Page<UserDTO> getAllUsersByPage(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return pageUserToDTO(userPage);
    }
    public void updateCurrentUser(UserUpdateRequest userUpdateRequest) {
        User currentUser = getCurrentUser();
        noPermittedBuiltIn(currentUser);
        boolean emailExist = userRepository.existsByEmail(userUpdateRequest.getEmail());
        canNotUpdatedEmailConfliction(userUpdateRequest, currentUser, emailExist);
        userRepository.update(currentUser.getId(), userUpdateRequest.getFirstName(), userUpdateRequest.getLastName(),
                userUpdateRequest.getPhoneNumber(), userUpdateRequest.getEmail(), userUpdateRequest.getAddress(),
                userUpdateRequest.getZipCode());
    }
    public void updateUserById(Long id, AdminUserUpdateRequest adminUserUpdateRequest) {
        User user = getUserById(id);
        noPermittedBuiltIn(user);
        boolean emailExist = userRepository.existsByEmail(adminUserUpdateRequest.getEmail());
        canNotUpdatedEmailConfliction(adminUserUpdateRequest, user, emailExist);
        if (adminUserUpdateRequest.getEmail() == null){
            adminUserUpdateRequest.setPassword(user.getPassword());
        } else {
            String encodedPassword = passwordEncoder.encode(adminUserUpdateRequest.getPassword());
            adminUserUpdateRequest.setPassword(encodedPassword);
        }
        Set<String> userStrRoles = adminUserUpdateRequest.getRoles();
        Set<Role> roles = convertRoles(userStrRoles);

        user.setFirstName(adminUserUpdateRequest.getFirstName());
        user.setLastName(adminUserUpdateRequest.getLastName());
        user.setAddress(adminUserUpdateRequest.getAddress());
        user.setZipCode(adminUserUpdateRequest.getZipCode());
        user.setPhoneNumber(adminUserUpdateRequest.getPhoneNumber());
        user.setEmail(adminUserUpdateRequest.getEmail());
        user.setBuiltIn(adminUserUpdateRequest.getBuiltIn());
        user.setPassword(adminUserUpdateRequest.getPassword());
        user.setRoles(roles);
        userRepository.save(user);
    }

}
