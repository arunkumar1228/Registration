package com.example.security.Mcq.Test.service;

import com.example.security.Mcq.Test.dto.QuestionDto;
import com.example.security.Mcq.Test.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    String saveQuestion(QuestionDto questionDto);

    public List<QuestionDto> getAllQuestion ();
    String  deleteQuestionById (Long id);

    Optional<Question> getQuestionById(Long id);

}
