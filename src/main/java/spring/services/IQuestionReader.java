package spring.services;

import spring.domain.Question;

import java.util.List;

public interface IQuestionReader {
    /**
     * Метод возвращает все вопросы из файла
     * @return
     */
    List<Question> getAll();
}
