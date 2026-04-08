package com.apirest.quizapp.service;

import com.apirest.quizapp.dto.request.CheckAnswersRequest;
import com.apirest.quizapp.dto.request.QuizRequest;
import com.apirest.quizapp.dto.response.QuestionResponse;
import com.apirest.quizapp.dto.response.QuizDetailResponse;
import com.apirest.quizapp.dto.response.QuizResponse;
import com.apirest.quizapp.handler.exceptions.ResourceNotFoundException;
import com.apirest.quizapp.mapper.QuestionMapper;
import com.apirest.quizapp.mapper.QuizMapper;
import com.apirest.quizapp.model.Answer;
import com.apirest.quizapp.model.Question;
import com.apirest.quizapp.model.Quiz;
import com.apirest.quizapp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizMapper quizMapper;
    private final QuestionMapper questionMapper;
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

    public QuizDetailResponse getQuizDetails(Integer id) {
        Quiz quizDetails = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        return quizMapper.toDetailsResponse(quizDetails);
    }

    public Integer checkAnswers(CheckAnswersRequest answers) {
        List<Question> questions = getQuizQuestions(answers.quizId());
        Map<Integer, String> mapRightAnswers = questions.stream()
                .collect(Collectors.toMap(Question::getId, Question::getRightAnswer));

        return (int) answers.answers().stream()
                .filter(answer -> {
                    String rightAnswer = mapRightAnswers.get(answer.getQuestionId());
                    return rightAnswer != null && rightAnswer.equals(answer.getOption());
                })
                .count();
    }

    private List<Question> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        return quiz.getQuestions();
    }
}
