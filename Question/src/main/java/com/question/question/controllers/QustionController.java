package com.question.question.controllers;

import com.question.question.entities.Question;
import com.question.question.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QustionController {
    private final QuestionService questionService;

    public QustionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuizQuestions(@PathVariable int quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestionById(@PathVariable int id) {
        questionService.deleteQustionById(id);
        return "Question deleted";
    }
}
