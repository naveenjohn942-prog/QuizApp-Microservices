package com.quiz.quiz.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private long id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private long quizId;
    private String correctAnswer;
}
