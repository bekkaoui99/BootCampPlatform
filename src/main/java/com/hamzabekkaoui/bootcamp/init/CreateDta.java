package com.hamzabekkaoui.bootcamp.init;

import com.hamzabekkaoui.bootcamp.dto.request.RegisterRequest;
import com.hamzabekkaoui.bootcamp.entity.User;
import com.hamzabekkaoui.bootcamp.enums.Role;
import com.hamzabekkaoui.bootcamp.service.implementation.UserServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CreateDta {

    @Bean
    public CommandLineRunner commandLineRunner(UserServiceImp userServiceImp , PasswordEncoder passwordEncoder){
        return args -> {
            RegisterRequest hamza = RegisterRequest.builder()
                    .userName("hamza")
                    .mail("hamza@gmail.com")
                    .phoneNumber("12345")
                    .password("1234")
                    .confirmationPassword("1234")
                    .build();
            userServiceImp.register(hamza);
        };

    }
}
