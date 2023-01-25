package com.example.security.Mcq.Test.controller;

import com.example.security.Mcq.Test.dto.QuestionDto;
import com.example.security.Mcq.Test.entity.Question;
import com.example.security.Mcq.Test.service.QuestionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "v1/Question")
@CrossOrigin("http://localhost:4200")
public class QuestionController {

    private final QuestionServiceImpl  questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }


    @PostMapping(value = "/saveQuestion")
    public String saveQuestion(@RequestBody QuestionDto questionDto) {
        return questionService.saveQuestion(questionDto);
    }
    @GetMapping(value = "/getAllQuestion")
    public List<QuestionDto> getAll() {
        return questionService.getAllQuestion();
    }

    @GetMapping(value = "/getQuestionById/{id}")
    public Optional<Question> getFeedBack(@PathVariable("id") Long id) {
        return questionService.getQuestionById(id);
    }

    @DeleteMapping("/deleteQuestionById/{id}")
    public String delete(@PathVariable("id") Long id) {
        return questionService.deleteQuestionById(id);
    }
}
