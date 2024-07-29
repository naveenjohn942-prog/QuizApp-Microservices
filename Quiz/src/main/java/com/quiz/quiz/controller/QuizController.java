package com.quiz.quiz.controller;

import com.quiz.quiz.entity.Quiz;
import com.quiz.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }
    @GetMapping
    public List<Quiz> getAllQuiz() {
        return quizService.get();
    }
    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return quizService.get(id);
    }
}
