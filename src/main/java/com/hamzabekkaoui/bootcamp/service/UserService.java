package com.hamzabekkaoui.bootcamp.service;

import com.hamzabekkaoui.bootcamp.dto.request.AuthenticationRequest;
import com.hamzabekkaoui.bootcamp.dto.request.RegisterRequest;
import com.hamzabekkaoui.bootcamp.dto.response.AuthenticationResponse;
import com.hamzabekkaoui.bootcamp.dto.response.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authentication(AuthenticationRequest authenticationRequest);
}
