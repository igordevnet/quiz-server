package com.apirest.quizapp.dto.response;

public record QuizResponse(
        Integer id,
        String category,
        String title,
        Integer nQuestions
) {
}
