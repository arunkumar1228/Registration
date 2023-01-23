package com.example.security.Mcq.Test.dto;

import com.example.security.Mcq.Test.entity.Answer;
import com.example.security.Mcq.Test.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

private Question  question;

}
