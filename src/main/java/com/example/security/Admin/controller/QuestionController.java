package com.example.security.Admin.controller;

import com.example.security.Admin.entity.Question;
import com.example.security.Admin.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping
    public Question createAuthor(@RequestBody Question question) {
        return questionService.save(question);
    }

    @GetMapping("/{id}")
    public Optional<Question> getAuthorById(@PathVariable(value = "id") Long authorId) {
        return questionService.findById(authorId);
    }

    @GetMapping
    public List<Question> getAllAuthors() {
        return questionService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        questionService.deleteById(authorId);
        return ResponseEntity.ok().build();
    }
}
