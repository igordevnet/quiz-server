package com.apirest.quizapp.dto.request;

import com.apirest.quizapp.model.Answer;

import java.util.List;

public record CheckAnswersRequest(
        Integer quizId,
        List<Answer> answers
) {
}
