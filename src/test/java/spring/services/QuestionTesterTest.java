package spring.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.Main;
import spring.domain.Question;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Main.class})
public class QuestionTesterTest {

    @Autowired
    private IQuestionTester questionTester;

    @Test
    public void isRightAnswer() {
        Question question = new Question();
        question.setQuestion("Сколько ног у рыбы");
        List<String> answers = new ArrayList<>();
        Collections.addAll(answers, "0", "1", "2", "3");
        question.setAnswers(answers);
        Assert.assertTrue(questionTester.isRightAnswer(question, "0"));
        Assert.assertFalse(questionTester.isRightAnswer(question, "1"));
    }
}