package com.web.Quiz.controller;


import com.web.Quiz.dto.QuestionDto;
import com.web.Quiz.model.Question;
import com.web.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("v1/Quiz")
public class QuestionController {
@Autowired
QuestionService questionService;

    @GetMapping("/getAllQuestion")
    public ResponseEntity<List<QuestionDto>> allQuestionList() {
        List<QuestionDto>list = questionService.getAllQuestion();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/createQuestion")
    public ResponseEntity<String> uploadQuestion( @RequestBody QuestionDto questionDto) {
        try {
            questionService.createQuestion(questionDto);
            return ResponseEntity.ok().body("question saved successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving Question.");
        }

    }

    @DeleteMapping("/deleteQuestionById")
    public  String deleteQuestionById(@RequestParam int qusId)   {
        return questionService.deleteQuestion(qusId);
    }

    @GetMapping("/getQuestionById")
    public QuestionDto getQuestion(@RequestParam int qusId)  {
        return questionService.getQuestionById(qusId);
    }


    @PutMapping(value = "/updateQuestionDetailsById")
    public ResponseEntity<QuestionDto> updateQuestion(@RequestParam int qusId,@RequestBody QuestionDto questionDto)  {
        return new ResponseEntity<>(questionService.updateQuestionDetails(qusId,questionDto), HttpStatus.OK);
    }



}
