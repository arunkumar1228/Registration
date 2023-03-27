package com.web.Quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private int ansId;

    @Column(name = "option")
    private String option;

    @Column(name = "correct")
    private boolean correct;
}
