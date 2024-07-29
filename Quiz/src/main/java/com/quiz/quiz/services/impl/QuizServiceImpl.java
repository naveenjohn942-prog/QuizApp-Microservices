package com.quiz.quiz.services.impl;

import com.quiz.quiz.entity.Quiz;
import com.quiz.quiz.repository.QuizRepository;
import com.quiz.quiz.services.QuestionClient;
import com.quiz.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizzes = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuizQuestions(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizzes;
    }

    @Override
    public Quiz get(long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuizQuestions(quiz.getId()));
        return quiz;
    }
}
