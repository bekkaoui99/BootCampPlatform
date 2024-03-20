package com.hamzabekkaoui.bootcamp.controller;

import com.hamzabekkaoui.bootcamp.dto.request.AuthenticationRequest;
import com.hamzabekkaoui.bootcamp.dto.request.RegisterRequest;
import com.hamzabekkaoui.bootcamp.dto.response.AuthenticationResponse;
import com.hamzabekkaoui.bootcamp.dto.response.RegisterResponse;
import com.hamzabekkaoui.bootcamp.service.implementation.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserServiceImp userServiceImp;

    @GetMapping("/test")
    public String test(){
        return "it is working";
    }


    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse register = userServiceImp.register(registerRequest);
        return new ResponseEntity<>(register , HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return userServiceImp.authentication(authenticationRequest);
    }
}
