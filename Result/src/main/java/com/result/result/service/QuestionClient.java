package com.result.result.service;

import com.result.result.entity.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Question")
public interface QuestionClient {


    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuizQuestions(@PathVariable("quizId") Long quizId);
}
