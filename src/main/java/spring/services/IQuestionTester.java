package spring.services;

import spring.domain.Question;

public interface IQuestionTester {

    /**
     * Метод проверяет, является ли ответ правильным
     * @param question
     * @param answer
     * @return
     */
    boolean isRightAnswer(Question question, String answer);

    /**
     * Метод возвращает правильный ответ
     * @param question
     * @return
     */
    String getRightAnswer(Question question);

}
