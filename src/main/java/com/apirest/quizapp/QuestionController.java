package com.apirest.quizapp;

import com.apirest.quizapp.dto.QuestionRequest;
import com.apirest.quizapp.dto.QuestionResponse;
import com.apirest.quizapp.model.Question;
import com.apirest.quizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/questions/category/{category}")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByCategory(
            @PathVariable() String category
    ) {
        return ResponseEntity.ok(questionService.getQuestionsByCategory(category));
    }

    @GetMapping("/questions/level/{level}")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByDifficultyLevel(
            @PathVariable() String level
    ) throws Exception {
        return ResponseEntity.ok(questionService.getQuestionsByDifficultLevel(level));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(
            @RequestBody() QuestionRequest question
    ) {
        questionService.addQuestion(question);

        return new ResponseEntity<>("New question created successfully!", HttpStatus.CREATED);
    }
}
