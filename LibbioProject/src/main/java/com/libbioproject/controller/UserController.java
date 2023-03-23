package com.libbioproject.controller;

import com.libbioproject.dto.UserDTO;
import com.libbioproject.dto.request.AdminUserUpdateRequest;
import com.libbioproject.dto.request.UpdatePasswordRequest;
import com.libbioproject.dto.request.UserUpdateRequest;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/auth/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }
    @PreAuthorize("(hasRole('ADMIN') or hasRole('CUSTOMER'))")
    @GetMapping
    public ResponseEntity<UserDTO> getCurrentUser(){
        UserDTO userDTO = userService.getPrincipal();
        return ResponseEntity.ok(userDTO);
    }
    @PreAuthorize("(hasRole('ADMIN'))")
    @GetMapping("/{id}/auth")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserDTOById(id);
        return ResponseEntity.ok(userDTO);
    }
    @PreAuthorize("(hasRole('ADMIN') or hasRole('CUSTOMER'))")
    @DeleteMapping
    public ResponseEntity<LResponse> deleteCurrentUser(){
        userService.deleteCurrentUser();
        LResponse response = new LResponse(ResponseMessage.USER_DELETE_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize("(hasRole('ADMIN'))")
    @DeleteMapping("/{id}/auth")
    public ResponseEntity<LResponse> deleteUserById(Long id){
        userService.deleteUserById(id);
        LResponse response = new LResponse(String.format(ResponseMessage.USER_DELETE_RESPONSE_MESSAGE, id), true);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize("(hasRole('ADMIN'))")
    @GetMapping("auth/pages")
    public ResponseEntity<Page<UserDTO>> getUsersByPage(@RequestParam int page,
                                                        @RequestParam int size,
                                                        @RequestParam String prop,
                                                        @RequestParam (value = "direction", required = false,
                                                        defaultValue = "DESC")Sort.Direction direction){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<UserDTO> userDTOPage = userService.getAllUsersByPage(pageable);
        return ResponseEntity.ok(userDTOPage);
    }
    @PreAuthorize("(hasRole('ADMIN') or hasRole('CUSTOMER'))")
    @PutMapping
    public ResponseEntity<LResponse> updateCurrentUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest){
        userService.updateCurrentUser(userUpdateRequest);
        LResponse response = new LResponse(ResponseMessage.USER_UPDATE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize("(hasRole('ADMIN'))")
    @PutMapping("{id}/auth")
    public ResponseEntity<LResponse> updateUserById(@PathVariable Long id,
                                                    @Valid @RequestBody AdminUserUpdateRequest adminUserUpdateRequest){
        userService.updateUserById(id, adminUserUpdateRequest);
        LResponse response = new LResponse(ResponseMessage.USER_UPDATE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize("(hasRole('ADMIN') or hasRole('CUSTOMER'))")
    @PatchMapping("/auth/password")
    public ResponseEntity<LResponse> updatePassword(@Valid @RequestBody UpdatePasswordRequest updatePasswordRequest){
        userService.updatePassword(updatePasswordRequest);
        LResponse response = new LResponse(ResponseMessage.PASSWORD_UPDATE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }


}
