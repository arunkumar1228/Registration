package com.web.Quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private int ansId;

    @Column(name = "option")
    private String option;

    @Column(name = "correct")
    private boolean correct;


}
