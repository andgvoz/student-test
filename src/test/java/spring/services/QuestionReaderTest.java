package spring.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.Main;
import spring.domain.Question;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Main.class})
public class QuestionReaderTest {

@Autowired
private IQuestionReader questionReader;

    @Test
    public void getAll() {
        List<Question> questions = questionReader.getAll();
        Assert.assertTrue("Ошибка чтения файла с вопросами", questions != null);
        Assert.assertTrue("Ошибка чтения вопросов из файла", questions.size() > 0);
    }
}