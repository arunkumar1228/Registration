package com.web.Quiz.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Data
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "qus_id")
    private int qusId;

    @Column(name = "qus_Name")
    private String qusName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_qus_id",referencedColumnName = "qus_id")
    private List<Answer> answers;

}
