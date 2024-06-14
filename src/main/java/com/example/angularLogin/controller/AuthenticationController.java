package com.example.angularLogin.controller;

import com.example.angularLogin.dtos.LoginUserDto;
import com.example.angularLogin.dtos.RegisterUserDto;
import com.example.angularLogin.entities.UserEntity;
import com.example.angularLogin.responses.LoginResponse;
import com.example.angularLogin.service.AuthenticationService;
import com.example.angularLogin.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(
            @RequestBody RegisterUserDto registerUserDto
            ){
        UserEntity user = authenticationService.signup(registerUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate (
            @RequestBody LoginUserDto loginUserDto
            ){
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(jwtToken);
            loginResponse.setExpiresIn(jwtService.getExpirationTime());

            return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }


}
