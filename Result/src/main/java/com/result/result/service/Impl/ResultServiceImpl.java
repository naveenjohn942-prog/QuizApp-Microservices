package com.result.result.service.Impl;

import com.result.result.entity.Question;
import com.result.result.entity.Result;
import com.result.result.entity.User;
import com.result.result.repository.ResultRepository;
import com.result.result.service.QuestionClient;
import com.result.result.service.ResultService;
import com.result.result.service.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Service
public class ResultServiceImpl implements ResultService {
    private final Logger logger = LoggerFactory.getLogger(ResultServiceImpl.class);

    private final ResultRepository resultRepository;
    private final UserClient userClient;
    private final QuestionClient questionClient;

    public ResultServiceImpl(ResultRepository resultRepository, UserClient userClient, QuestionClient questionClient) {
        this.resultRepository = resultRepository;
        this.userClient = userClient;
        this.questionClient = questionClient;
    }

    @Override
    public List<Result> getResultsByUserId(Long userId) {
        return resultRepository.findByUserId(userId);
    }

    @Override
    public List<Result> getResultsByQuizId(Long quizId) {
        return resultRepository.findByQuizId(quizId);
    }

    @Override
    public Result getResult(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public Result calculateResult(Long quizId, Long userId, List<Long> questionIds, List<String> answers) {
        logger.info("Calculating result for quizId: {}, userId: {}", quizId, userId);

        User user = userClient.getUserById(userId);
        if (user == null) {
            logger.error("User not found for userId: {}", userId);
            throw new RuntimeException("User not found");
        }

        List<Question> questions = questionClient.getQuizQuestions(quizId);
        if (questions == null || questions.isEmpty()) {
            logger.error("Questions not found for quizId: {}", quizId);
            throw new RuntimeException("Questions not found");
        }

        if (questionIds.size() != answers.size()) {
            logger.warn("Number of question IDs ({}) does not match number of answers ({})", questionIds.size(), answers.size());
            throw new IllegalArgumentException("Number of question IDs does not match number of answers");
        }

        int score = 0;
        Map<Long, String> answersMap = new HashMap<>();
        for (int i = 0; i < questionIds.size(); i++) {
            answersMap.put(questionIds.get(i), answers.get(i));
        }

        for (Question question : questions) {
            if (answersMap.containsKey(question.getId()) && Objects.equals(question.getCorrectAnswer(), answersMap.get(question.getId()))) {
                score++;
            }
        }

        Result result = new Result();
        result.setQuizId(quizId);
        result.setUserId(userId);
        result.setScore(score);

        return resultRepository.save(result);
    }




    @Override
    public Result getResultByUserIdAndQuizId(Long userId, Long quizId) {
        return resultRepository.findByUserIdAndQuizId(userId, quizId);
    }

    @Override
    public Result addResult(Result result) {
        return resultRepository.save(result);
    }
}
