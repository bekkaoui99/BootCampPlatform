package com.hamzabekkaoui.bootcamp.repository;

import com.hamzabekkaoui.bootcamp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {

    Optional<User> findByMail(String mail);
}
