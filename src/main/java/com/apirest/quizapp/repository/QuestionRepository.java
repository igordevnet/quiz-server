package com.apirest.quizapp.repository;

import com.apirest.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByDifficultyLevel(String level);
    List<Question> findByCategory(String category);
}
