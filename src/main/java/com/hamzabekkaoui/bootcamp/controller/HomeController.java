package com.hamzabekkaoui.bootcamp.controller;

import com.hamzabekkaoui.bootcamp.dto.request.AuthenticationRequest;
import com.hamzabekkaoui.bootcamp.dto.request.RegisterRequest;
import com.hamzabekkaoui.bootcamp.dto.response.AuthenticationResponse;
import com.hamzabekkaoui.bootcamp.dto.response.RegisterResponse;
import com.hamzabekkaoui.bootcamp.service.implementation.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public String home(){
        return "it is working";
    }

}
