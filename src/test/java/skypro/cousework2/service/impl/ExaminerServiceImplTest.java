package skypro.cousework2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.cousework2.model.Question;

import java.util.*;

import static org.assertj.core.api.BDDAssumptions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldCorrectRandomQuestions() {
        // given
        int amount = 3;

        Set<Question> questions = new HashSet<>();
        questions.add(new Question(" Кто написал роман Война и мир ?", "Лев Николааевич Толстой"));
        questions.add(new Question(" Первый человек полетевший в космос ?", "Гагарин Юрий Алексеевич"));
        questions.add(new Question(" Какая гора самая высокая ?", "Эверест"));
        questions.add(new Question(" Какое море самое соленое", "Мертвое"));
        questions.add(new Question(" Какие типы исключения бывают", "Проверяемые / непроверяемые"));
        ArrayList<Question> questionsList = new ArrayList<>(questions);


        when(questionService.getAll()).thenReturn(questions);// с given не почему то не получается, willReturn красным подсвечивается!!!!
        when(questionService.getRandomQuestion()).thenReturn(
                questionsList.get(0),
                questionsList.get(0),
                questionsList.get(0),
                questionsList.get(1),
                questionsList.get(1),
                questionsList.get(2),
                questionsList.get(2)
        );

        // when
        Collection<Question> actualRandomQuestions = examinerService.getQuestions(amount);
        // then
        Assertions.assertEquals(new HashSet<>(List.of(questionsList.get(0), questionsList.get(1), questionsList.get(2))), actualRandomQuestions);


    }
}
