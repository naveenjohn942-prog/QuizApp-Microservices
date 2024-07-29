package com.quiz.quiz.services;

import com.quiz.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);
    List<Quiz> get();
    Quiz get(long id);
}
