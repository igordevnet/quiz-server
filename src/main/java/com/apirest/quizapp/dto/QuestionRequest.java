package com.apirest.quizapp.dto;

import com.apirest.quizapp.model.Option;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public record QuestionRequest(
        Integer id,
        String questionTitle,
        String category,
        String rightAnswer,
        String difficultyLevel,
        List<Option> options
) { }
