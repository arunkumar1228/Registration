package com.example.security.Mcq.User.entity;


import lombok.Data;

import javax.persistence.*;

@Entity

@Table(name = "User_Details")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String userName;

    @Column(name = "emailId")
    private String EmailId;
    @Column(name = "phone")
    private  String PhoneNumber;


}
