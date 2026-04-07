package com.apirest.quizapp.service;

import com.apirest.quizapp.dto.QuestionRequest;
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
    private final OptionService optionService;

    public List<Question> getAllQuestions() {
       return questionRepository.findAll();
    }

    public void addQuestion(QuestionRequest question) {
        questionRepository.save(question);

        List<Option> options = question.getOptions();

        for(Option option : options){
            option.setQuestion(question);
        }

        optionService.saveOptions(options);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> getQuestionsByDifficultLevel(String level) {
        return questionRepository.findByDifficultyLevel(level);
    }
}
