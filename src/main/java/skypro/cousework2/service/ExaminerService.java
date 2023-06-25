package skypro.cousework2.service;

import skypro.cousework2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
