package spring.services;

import org.springframework.beans.factory.annotation.Value;
import spring.domain.Question;

import java.util.List;

public class QuestionTester implements IQuestionTester {

    @Value("${right.answer.index}")
    private int rightAnswerIndex;

    public boolean isRightAnswer(Question question, String answer) {
        if(question == null) {
            return false;
        }
        List<String> answers = question.getAnswers();
        if (answers == null || answers.size() == 0) {
            return false;
        }
        if (answers.get(0).equalsIgnoreCase(answer)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getRightAnswer(Question question) {
        String result = "";
        if (question != null) {
            List<String> answers = question.getAnswers();
            if (answers != null && !answers.isEmpty()) {
                result = answers.get(rightAnswerIndex);
            }
        }
        return result;
    }
}
