package com.web.Quiz.service;

import com.web.Exception.BannerNotFoundException;

import com.web.Quiz.dto.QuestionDto;
import com.web.Quiz.model.Answer;
import com.web.Quiz.model.Question;
import com.web.Quiz.repository.AnswerRepository;
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
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<QuestionDto> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream().map(question -> dozerBeanMapper.map(question, QuestionDto.class)).collect(Collectors.toList());

    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = dozerBeanMapper.map(questionDto, Question.class);
        question.setQusName(questionDto.getQusName());
        question.setAnswers(questionDto.getAnswers());
        Question save = questionRepository.save(question);
        QuestionDto dto = dozerBeanMapper.map(save, QuestionDto.class);
        return dto;

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
        question1.setQusName(questionDto.getQusName());
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

    @Override public Long findAll(Boolean True) {

      return answerRepository.findAll(true);
    }
}
