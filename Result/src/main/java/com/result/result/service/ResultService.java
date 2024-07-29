package com.result.result.service;

import com.result.result.entity.Result;

import java.util.List;

public interface ResultService {
    Result addResult(Result result);
    List<Result> getResultsByUserId(Long userId);
    List<Result> getResultsByQuizId(Long quizId);
    Result getResult(Long id);
    Result calculateResult(Long quizId, Long userId, List<Long> questionIds, List<String> answers);

}
