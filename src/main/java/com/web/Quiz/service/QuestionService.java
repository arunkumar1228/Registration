package com.web.Quiz.service;


import com.web.Quiz.dto.QuestionDto;
import com.web.Quiz.model.Answer;
import com.web.Quiz.model.Question;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestion();

    QuestionDto createQuestion(QuestionDto questions);

    String deleteQuestion(int qusId);

    QuestionDto updateQuestionDetails(int qusId, QuestionDto questionDto);

    QuestionDto getQuestionById(int qusId) ;

    Long findAll(Boolean True);
}
