package spring;

import spring.domain.Question;
import org.junit.Assert;
import org.junit.Test;
import spring.services.IQuestionReader;
import spring.services.QuestionReader;

import java.util.List;

public class QuestionReaderTest {

private IQuestionReader questionReader = new QuestionReader("questions.csv");

    @Test
    public void getAll() {
        List<Question> questions = questionReader.getAll();
        Assert.assertTrue("Ошибка чтения файла с вопросами", questions != null);
        Assert.assertTrue("Ошибка чтения вопросов из файла", questions.size() > 0);
    }
}