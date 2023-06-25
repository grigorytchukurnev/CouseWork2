package skypro.cousework2.service.impl;

import org.springframework.stereotype.Service;
import skypro.cousework2.exception.NotEnoughQuestionsInException;
import skypro.cousework2.model.Question;
import skypro.cousework2.service.ExaminerService;
import skypro.cousework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (amount > size) {
            throw new NotEnoughQuestionsInException();
        }


        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }
            return questions;
    }
}
