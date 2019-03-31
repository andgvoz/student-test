package spring.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String question;
    private List<String> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<String> getShuffledAnswers() {
        List<String> shuffledAnswera = new ArrayList<>(answers);
        Collections.shuffle(shuffledAnswera);
        return shuffledAnswera;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("question='").append(question).append('\'');
        sb.append(", answers=").append(answers);
        sb.append('}');
        return sb.toString();
    }
}
