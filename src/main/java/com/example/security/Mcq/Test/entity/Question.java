package com.example.security.Mcq.Test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Question;

    @OneToMany(targetEntity = Answer.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="question_id",referencedColumnName = "id")
    private List<Answer> answers;

}
