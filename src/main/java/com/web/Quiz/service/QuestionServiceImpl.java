package com.web.Quiz.service;

import com.web.Exception.BannerNotFoundException;
import com.web.Quiz.dto.QuestionDto;
import com.web.Quiz.model.Question;
import com.web.Quiz.repository.QuestionRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<QuestionDto> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream().map(question -> dozerBeanMapper.map(question, QuestionDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<QuestionDto> createQuestion(List<QuestionDto> questionDto) {
        List<QuestionDto> savedQuestions = new ArrayList<>();
        Question question = new Question();
        for (QuestionDto dto : questionDto) {
            // Convert QuestionDto to Question entity

            question.setQusId(dto.getQusId());
            question.setQuestionName(dto.getQuestionName());
            question.setAnswers(dto.getAnswers());

        }
        Question question1 = questionRepository.save(question);
        QuestionDto dto = dozerBeanMapper.map(question1, QuestionDto.class);
        savedQuestions.add(dto);
        return savedQuestions;
    }

    @Override
    public String deleteQuestion(int qusId) {
        try {
            questionRepository.deleteById(qusId);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public QuestionDto updateQuestionDetails(int qusId, QuestionDto questionDto) {
        Optional<Question> question = questionRepository.findById(qusId);
        Question question1 = question.get();
        question1.setQusId(questionDto.getQusId());
        question1.setQuestionName(questionDto.getQuestionName());
        question1.setAnswers(questionDto.getAnswers());


        Question save = questionRepository.save(question1);
        QuestionDto dto = dozerBeanMapper.map(save, QuestionDto.class);
        return dto;
    }

    @Override
    public QuestionDto getQuestionById(int qusId) {
        Optional<Question> question = questionRepository.findById(qusId);
        Question question1 = question.get();
        QuestionDto questionDto = dozerBeanMapper.map(question1, QuestionDto.class);
        return questionDto;
    }
}
