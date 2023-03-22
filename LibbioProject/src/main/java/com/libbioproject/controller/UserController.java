package com.libbioproject.controller;

import com.libbioproject.dto.UserDTO;
import com.libbioproject.dto.request.AdminUserUpdateRequest;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/auth/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }
    @GetMapping
    public ResponseEntity<UserDTO> getCurrentUser(){
        UserDTO userDTO = userService.getPrincipal();
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping("/{id}/auth")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserDTOById(id);
        return ResponseEntity.ok(userDTO);
    }
    @DeleteMapping
    public ResponseEntity<LResponse> deleteCurrentUser(){
        userService.deleteCurrentUser();
        LResponse response = new LResponse(ResponseMessage.USER_DELETE_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}/auth")
    public ResponseEntity<LResponse> deleteUserById(Long id){
        userService.deleteUserById(id);
        LResponse response = new LResponse(String.format(ResponseMessage.USER_DELETE_RESPONSE_MESSAGE, id), true);
        return ResponseEntity.ok(response);
    }
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
    @PutMapping
    public ResponseEntity<LResponse> updateCurrentUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest){
        userService.updateCurrentUser(userUpdateRequest);
        LResponse response = new LResponse(ResponseMessage.USER_UPDATE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }
    @PutMapping("{id}/auth")
    public ResponseEntity<LResponse> updateUserById(@PathVariable Long id,
                                                    @Valid @RequestBody AdminUserUpdateRequest adminUserUpdateRequest){
        userService.updateUserById(id, adminUserUpdateRequest);
        LResponse response = new LResponse(ResponseMessage.USER_UPDATE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }


}
