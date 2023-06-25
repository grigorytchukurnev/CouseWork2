package skypro.cousework2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import skypro.cousework2.model.Question;
import skypro.cousework2.service.QuestionService;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @PostConstruct
    public void initQuestions(){
        questions.add(new Question(" Кто написал роман Война и мир ?", "Лев Николааевич Толстой"));
        questions.add(new Question(" Первый человек полетевший в космос ?", "Гагарин Юрий Алексеевич"));
        questions.add(new Question(" Какая гора самая высокая ?", "Эверест"));
        questions.add(new Question(" Какое море самое соленое", "Мертвое"));
        questions.add(new Question(" Какие типы исключения бывают", "Проверяемые / непроверяемые"));
    }

    @Override
    public Question add(String questionText, String answer) {
        return add(new Question(questionText, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return (new ArrayList<>(questions)).get(randomIndex);
    }
}
