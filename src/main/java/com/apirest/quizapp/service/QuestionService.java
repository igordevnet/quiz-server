package com.apirest.quizapp.service;

import com.apirest.quizapp.dto.QuestionRequest;
import com.apirest.quizapp.dto.QuestionResponse;
import com.apirest.quizapp.mapper.QuestionMapper;
import com.apirest.quizapp.model.Option;
import com.apirest.quizapp.model.Question;
import com.apirest.quizapp.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public List<QuestionResponse> getAllQuestions() {

        List<Question> questions = questionRepository.findAll();

        return questionMapper.toResponseList(questions);
    }

    public void addQuestion(QuestionRequest questionReq) {
        Question question = questionMapper.toEntity(questionReq);

        questionRepository.save(question);

        if (question.getOptions() != null) {
            question.getOptions().forEach(option -> option.setQuestion(question));
        }
    }

    public List<QuestionResponse> getQuestionsByCategory(String category) {
        List<Question> questions = questionRepository.findByCategory(category);

        return questionMapper.toResponseList(questions);
    }

    public List<QuestionResponse> getQuestionsByDifficultLevel(String level) {
        List<Question> questions = questionRepository.findByDifficultyLevel(level);

        return questionMapper.toResponseList(questions);
    }
}
