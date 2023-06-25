package skypro.cousework2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skypro.cousework2.model.Question;
import skypro.cousework2.service.QuestionService;

import java.util.Collection;

public class JavaQuestionServiceTest {
    private final QuestionService questionService = new  JavaQuestionService();

    @Test
    public void shouldCorrectlyAddNewQuestion(){
        // given
        Question question = new Question("question","answer");
        // when
        Question addedQuestion = questionService.add(question);
        // then
        Assertions.assertEquals(question, addedQuestion);
    }

    @Test
    public void shouldReturnAllExistedQuestion(){
        // given
        Question question = new Question("question","answer");
        questionService.add(question);
        // when
        Collection<Question> all = questionService.getAll();
        // then
        Assertions.assertEquals(all.size(),1);
    }
}
