package com.web.Quiz.service;

import com.web.Quiz.dto.QuestionDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestion();

    List<QuestionDto> createQuestion(List<QuestionDto> questionDto);

    String deleteQuestion(int qusId);

    QuestionDto updateQuestionDetails(int qusId, QuestionDto questionDto);

    QuestionDto getQuestionById(int qusId) ;
}
