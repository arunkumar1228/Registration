package com.web.Quiz.service;


import com.web.Quiz.model.Question;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();

     String createQuestion(List<Question> questions);

//    String deleteQuestion(int qusId);
//
//    QuestionDto updateQuestionDetails(int qusId, QuestionDto questionDto);
//
//    QuestionDto getQuestionById(int qusId) ;
}
