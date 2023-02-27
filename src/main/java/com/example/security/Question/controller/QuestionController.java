package com.example.security.Question.controller;

import com.example.security.Question.entity.Question;
import com.example.security.Question.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping(value = "AddAllQuestion")
    public Question createAuthor(@RequestBody Question question) {
        return questionService.save(question);
    }

    @GetMapping("GetQuestionById/{id}")
    public Optional<Question> getAuthorById(@PathVariable(value = "id") Long authorId) {
        return questionService.findById(authorId);
    }

    @GetMapping
    public List<Question> getAllAuthors() {
        return questionService.findAll();
    }

    @DeleteMapping("DetailsQuestionById/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        questionService.deleteById(authorId);
        return ResponseEntity.ok().build();
    }
}
