package com.apirest.quizapp.dto;

import com.apirest.quizapp.model.Option;

import java.util.List;

public record QuestionRequest(
        Integer id,
        String questionTitle,
        String category,
        String rightAnswer,
        String difficultyLevel,
        List<Option> options
) { }
