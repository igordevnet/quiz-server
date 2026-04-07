package com.apirest.quizapp;

import com.apirest.quizapp.dto.QuestionRequest;
import com.apirest.quizapp.model.Question;
import com.apirest.quizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() throws Exception {
        return questionService.getAllQuestions();
    }

    @GetMapping("/questions/category/{category}")
    public List<Question> getQuestionsByCategory(
            @PathVariable() String category
    ) throws Exception {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/questions/level/{level}")
    public List<Question> getQuestionsByDifficultyLevel(
            @PathVariable() String level
    ) throws Exception {
        return questionService.getQuestionsByDifficultLevel(level);
    }

    @PostMapping("/add")
    public void addQuestion(
            @RequestBody() QuestionRequest question
    ) {
        questionService.addQuestion(question);
    }
}
