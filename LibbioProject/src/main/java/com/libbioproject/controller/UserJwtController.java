package com.libbioproject.controller;

import com.libbioproject.dto.request.LoginRequest;
import com.libbioproject.dto.request.RegisterRequest;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.LoginResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.security.jwt.JwtUtils;
import com.libbioproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserJwtController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<LResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest){
        userService.registerUser(registerRequest);
        LResponse response = new LResponse(ResponseMessage.USER_REGISTER_RESPONSE_MESSAGE, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication authentication =authenticationManager.authenticate(authenticationToken);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(userDetails);
        LoginResponse response = new LoginResponse(jwtToken);
        return ResponseEntity.ok(response);
    }
}
