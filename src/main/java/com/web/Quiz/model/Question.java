package com.web.Quiz.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @Column(name = "qus_id")
    private int qusId;

    private String questionName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_ans_id")
    private List<Answer> answers;


}
