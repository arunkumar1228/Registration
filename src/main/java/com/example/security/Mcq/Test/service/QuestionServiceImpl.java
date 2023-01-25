package com.example.security.Mcq.Test.service;

import com.example.security.Mcq.Test.dto.QuestionDto;
import com.example.security.Mcq.Test.entity.Answer;
import com.example.security.Mcq.Test.entity.Question;
import com.example.security.Mcq.Test.repository.AnswerRepository;
import com.example.security.Mcq.Test.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<QuestionDto> getAllQuestion() {

        List<Question> cv = questionRepository.findAll();
        return cv.stream().map(banner -> modelMapper.map(banner, QuestionDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public String deleteQuestionById(Long id) {
        try {
            questionRepository.deleteById(id);
            return "Deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }


}

