package com.result.result.repository;

import com.result.result.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUserId(Long userId);
    List<Result> findByQuizId(Long quizId);

    Result findByUserIdAndQuizId(Long userId, Long quizId);
}
