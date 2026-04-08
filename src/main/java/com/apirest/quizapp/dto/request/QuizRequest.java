package com.apirest.quizapp.dto.request;

public record QuizRequest(
        String category,
        Integer nQuestions,
        String title
) {
}
