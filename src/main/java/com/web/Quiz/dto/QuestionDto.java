package com.web.Quiz.dto;

import com.web.Quiz.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private int qusId;


    private String qusName;

    @OneToMany
    private List<Answer> answers;
}
