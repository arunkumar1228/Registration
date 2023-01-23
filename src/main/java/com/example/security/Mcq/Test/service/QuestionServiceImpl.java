package com.example.security.Mcq.Test.service;

import com.example.security.Mcq.Test.dto.QuestionDto;
import com.example.security.Mcq.Test.entity.Answer;
import com.example.security.Mcq.Test.entity.Question;
import com.example.security.Mcq.Test.repository.AnswerRepository;
import com.example.security.Mcq.Test.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final   AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private  final ModelMapper modelMapper;

    public QuestionServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public String saveQuestion(QuestionDto questionDto) {
        questionRepository.save(questionDto.getQuestion());
        return "Ok";
    }
}

