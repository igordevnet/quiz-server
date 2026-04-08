package com.apirest.quizapp.controller;

import com.apirest.quizapp.dto.request.QuizRequest;
import com.apirest.quizapp.dto.response.QuizResponse;
import com.apirest.quizapp.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizRequest quizRequest) {
        quizService.createQuiz(quizRequest);

        return ResponseEntity.ok("Quiz created");
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<QuizResponse>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }
}
