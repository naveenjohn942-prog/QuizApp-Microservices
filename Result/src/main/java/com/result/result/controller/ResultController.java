package com.result.result.controller;

import com.result.result.dto.CalculateResultRequest;
import com.result.result.entity.Result;
import com.result.result.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.addResult(result);
    }

    @GetMapping("/user/{userId}")
    public List<Result> getResultsByUserId(@PathVariable Long userId) {
        return resultService.getResultsByUserId(userId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Result> getResultsByQuizId(@PathVariable Long quizId) {
        return resultService.getResultsByQuizId(quizId);
    }

    @GetMapping("/{id}")
    public Result getResult(@PathVariable Long id) {
        return resultService.getResult(id);
    }

    @PostMapping("/calculate")
    public Result calculateResult(@RequestParam Long quizId, @RequestParam Long userId, @RequestBody CalculateResultRequest request) {
        return resultService.calculateResult(quizId, userId, request.getQuestionIds(), request.getAnswers());
    }

    @GetMapping("/user/{userId}/quiz/{quizId}")
    public Result getResultByUserIdAndQuizId(@PathVariable Long userId, @PathVariable Long quizId) {
        return resultService.getResultByUserIdAndQuizId(userId, quizId);
    }
}
