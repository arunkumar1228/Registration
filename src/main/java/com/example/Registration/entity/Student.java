package com.example.Registration.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
@Column
    private String Name;
    @Column
    private int Dob ;
    @Column
    private String Occupation ;
    @Column
    private  int Experience;


}
