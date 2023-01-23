package com.example.security.Mcq.Test.controller;

import com.example.security.Mcq.Test.dto.QuestionDto;
import com.example.security.Mcq.Test.service.QuestionServiceImpl;
import org.springframework.web.bind.annotation.*;


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

}
