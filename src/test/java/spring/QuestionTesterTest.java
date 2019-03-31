package spring;

import spring.domain.Question;
import org.junit.Assert;
import org.junit.Test;
import spring.services.IQuestionTester;
import spring.services.QuestionTester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionTesterTest {

    private IQuestionTester questionTester = new QuestionTester();

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