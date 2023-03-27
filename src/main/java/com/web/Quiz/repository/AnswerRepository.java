package com.web.Quiz.repository;

import com.web.Quiz.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query(value = "SELECT COUNT(answer.correct) FROM answer WHERE answer.correct = ?",nativeQuery = true)
   Long findAll(Boolean True);


}
