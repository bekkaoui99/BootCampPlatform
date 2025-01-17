package com.hamzabekkaoui.bootcamp.security.service;

import com.hamzabekkaoui.bootcamp.repository.UserRepository;
import com.hamzabekkaoui.bootcamp.security.model.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByMail(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
