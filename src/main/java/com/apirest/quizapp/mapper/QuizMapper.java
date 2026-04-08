package com.apirest.quizapp.mapper;

import com.apirest.quizapp.dto.request.QuizRequest;
import com.apirest.quizapp.dto.response.QuizDetailResponse;
import com.apirest.quizapp.dto.response.QuizResponse;
import com.apirest.quizapp.model.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper {
    @Mapping(source = "NQuestions", target = "nQuestions")
    QuizResponse toResponse(Quiz quiz);

   QuizDetailResponse toDetailsResponse(Quiz quiz);

    List<QuizResponse> toResponseList(List<Quiz> quizzes);

    @Mapping(source = "nQuestions", target = "NQuestions")
    Quiz toEntity(QuizRequest request);
}
