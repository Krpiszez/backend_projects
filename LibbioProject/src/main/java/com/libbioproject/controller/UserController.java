package com.libbioproject.controller;

import com.libbioproject.dto.UserDTO;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
