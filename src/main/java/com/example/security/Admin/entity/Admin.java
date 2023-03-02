package com.example.security.Admin.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;


}