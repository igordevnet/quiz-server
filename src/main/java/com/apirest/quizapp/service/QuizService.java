package com.apirest.quizapp.service;

import com.apirest.quizapp.dto.request.QuizRequest;
import com.apirest.quizapp.dto.response.QuizResponse;
import com.apirest.quizapp.mapper.QuizMapper;
import com.apirest.quizapp.model.Question;
import com.apirest.quizapp.model.Quiz;
import com.apirest.quizapp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizMapper quizMapper;
    private final QuizRepository quizRepository;
    private final QuestionService questionService;

    public void createQuiz(QuizRequest quizRequest) {
        List<Question> questions = questionService.findRandomQuestionsByCategory(quizRequest.category(), quizRequest.nQuestions());

        Quiz quiz = quizMapper.toEntity(quizRequest);

        quiz.setQuestions(questions);

        quizRepository.save(quiz);
    }

    public List<QuizResponse> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();

        return quizMapper.toResponseList(quizzes);
    }
}
