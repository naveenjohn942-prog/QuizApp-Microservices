package com.result.result.service.Impl;

import com.result.result.entity.Question;
import com.result.result.entity.Result;
import com.result.result.entity.User;
import com.result.result.repository.ResultRepository;
import com.result.result.service.QuestionClient;
import com.result.result.service.ResultService;
import com.result.result.service.UserClient;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ResultServiceImpl implements ResultService {
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
        User user = userClient.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        List<Question> questions = questionClient.getQuizQuestions(quizId);

        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            String correctAnswer = questions.get(i).getCorrectAnswer();
            if (correctAnswer != null && correctAnswer.equals(answers.get(i))) {
                score++;
            }
        }

        Result result = new Result();
        result.setQuizId(quizId);
        result.setUserId(userId);
        result.setScore(score);

        return addResult(result);
    }

    @Override
    public Result addResult(Result result) {
        return resultRepository.save(result);
    }

}
