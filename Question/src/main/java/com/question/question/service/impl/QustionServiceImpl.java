package com.question.question.service.impl;

import com.question.question.entities.Question;
import com.question.question.repository.QuestionRepo;
import com.question.question.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class QustionServiceImpl implements QuestionService {

    private QuestionRepo questionRepo;

    public QustionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public Question getQuestionById(long id) {
        return questionRepo.findById(id);
    }

    @Override
    public void deleteQustionById(int id) {
        questionRepo.deleteById(id);

    }

    @Override
    public List<Question> getQuestionsOfQuiz(long id) {
        return questionRepo.findByQuizId(id);
    }

    @Override
    public void saveAll(List<Question> questions) {
        questionRepo.saveAll(questions);
    }
}
