package spring.services;

import spring.domain.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionReader implements IQuestionReader {
    private String fileName;

    public QuestionReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> getAll() {
        List<Question> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/main/resources/" + fileName))) {
            while (scanner.hasNextLine()) {
                Question question = new Question();
                question.setAnswers(new ArrayList<>());
                String line = scanner.nextLine();
                if (line != null) {
                    String[] parts = line.split(",");
                    for (int i = 0; i < parts.length; i++) {
                        if (i == 0) {
                            question.setQuestion(parts[0]);
                        } else {
                            question.getAnswers().add(parts[i]);
                        }
                    }
                }
                result.add(question);
            }
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return result;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionReader{");
        sb.append("fileName='").append(fileName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
