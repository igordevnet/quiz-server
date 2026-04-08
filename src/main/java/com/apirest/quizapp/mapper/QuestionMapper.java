package com.apirest.quizapp.mapper;

import com.apirest.quizapp.dto.QuestionRequest;
import com.apirest.quizapp.dto.QuestionResponse;
import com.apirest.quizapp.model.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionResponse toResponse(Question question);

    List<QuestionResponse> toResponseList(List<Question> questions);

    Question toEntity(QuestionRequest request);
}