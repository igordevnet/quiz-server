package com.apirest.quizapp.dto.response;

import java.util.List;

public record QuizDetailResponse(
        Integer id,
        String title,
        List<QuestionResponse> questions
) {}