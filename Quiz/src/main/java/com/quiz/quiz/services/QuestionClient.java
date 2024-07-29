package com.quiz.quiz.services;

import com.quiz.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082",value = "Qustion-Client")
@FeignClient(name="QUESTION")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizid}")
    List<Question> getQuizQuestions(@PathVariable long quizid);
}
