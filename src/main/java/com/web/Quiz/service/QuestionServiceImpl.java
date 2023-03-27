package com.web.Quiz.service;

import com.web.Exception.BannerNotFoundException;

import com.web.Quiz.model.Question;
import com.web.Quiz.repository.QuestionRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Question> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
//        return questions.stream().map(question -> dozerBeanMapper.map(question, QuestionDto.class)).collect(Collectors.toList());
       return questions;
    }

    @Override
    public String createQuestion(List<Question> questions) {
        questionRepository.saveAll(questions);
        return "OK";

    }


//    @Override
//    public String deleteQuestion(int qusId) {
//        try {
//            questionRepository.deleteById(qusId);
//        } catch (BannerNotFoundException e) {
//            return (e.getMessage());
//        }
//        return "Deleted Successfully";
//    }
//
//    @Override
//    public QuestionDto updateQuestionDetails(int qusId, QuestionDto questionDto) {
//        Optional<Question> question = questionRepository.findById(qusId);
//        Question question1 = question.get();
//     question1.setOptions(questionDto.getOptions());
//     question1.setCorrectAnswer(questionDto.getCorrectAnswer());
//        Question save = questionRepository.save(question1);
//        QuestionDto dto = dozerBeanMapper.map(save, QuestionDto.class);
//        return dto;
//    }
//
//    @Override
//    public QuestionDto getQuestionById(int qusId) {
//        Optional<Question> question = questionRepository.findById(qusId);
//        Question question1 = question.get();
//        QuestionDto questionDto = dozerBeanMapper.map(question1, QuestionDto.class);
//        return questionDto;
//    }
}
