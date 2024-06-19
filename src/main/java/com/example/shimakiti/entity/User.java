package com.example.shimakiti.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private int role;

}