package com.question.question.service;

import com.question.question.entities.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(long id);

    void deleteQustionById(int id);
    List<Question> getQuestionsOfQuiz(long id);

    void saveAll(List<Question> questions);
}
