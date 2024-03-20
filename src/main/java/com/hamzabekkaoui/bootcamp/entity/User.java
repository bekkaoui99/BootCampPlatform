package com.hamzabekkaoui.bootcamp.entity;


import com.hamzabekkaoui.bootcamp.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String mail;
    private String password;
    private String phoneNumber;

    private Role authority;

}