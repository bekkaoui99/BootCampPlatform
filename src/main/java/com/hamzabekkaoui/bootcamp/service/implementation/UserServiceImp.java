package com.hamzabekkaoui.bootcamp.service.implementation;

import com.hamzabekkaoui.bootcamp.dto.request.AuthenticationRequest;
import com.hamzabekkaoui.bootcamp.dto.request.RegisterRequest;
import com.hamzabekkaoui.bootcamp.dto.response.AuthenticationResponse;
import com.hamzabekkaoui.bootcamp.dto.response.RegisterResponse;
import com.hamzabekkaoui.bootcamp.entity.User;
import com.hamzabekkaoui.bootcamp.enums.Role;
import com.hamzabekkaoui.bootcamp.repository.UserRepository;
import com.hamzabekkaoui.bootcamp.security.model.SecurityUser;
import com.hamzabekkaoui.bootcamp.security.service.JwtService;
import com.hamzabekkaoui.bootcamp.security.service.UserDetailsServiceImp;
import com.hamzabekkaoui.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;




    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {

        Optional<User> doesTheUserExist = userRepository.findByMail(registerRequest.mail());
        if(doesTheUserExist.isPresent()){
            throw new IllegalArgumentException("this mail already exists");
        }
        if(!registerRequest.password().equals(registerRequest.confirmationPassword())){
            throw new IllegalArgumentException("confirmation password doesn't match");
        }
        User user = User.builder()
                .userName(registerRequest.userName())
                .mail(registerRequest.mail())
                .phoneNumber(registerRequest.phoneNumber())
                .password(passwordEncoder.encode(registerRequest.password()))
                .authority(Role.USER)
                .build();
        userRepository.save(user);


        return RegisterResponse.builder()
                .mail(user.getMail())
                .phoneNumber(user.getPhoneNumber())
                .userName(user.getUserName())
                .build();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.mail(), authenticationRequest.password())
        );
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", authenticate.getAuthorities());
        SecurityUser userDetail = userRepository.findByMail(authenticationRequest.mail())
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));


        String token = jwtService.generateToken(claims , userDetail);

        return AuthenticationResponse.builder()
                .userName(userDetail.getUsername())
                .jwt(token)
                .build();
    }

}
