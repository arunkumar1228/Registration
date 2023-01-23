package com.example.security.Mcq.Test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = "Option")

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Options;

}
