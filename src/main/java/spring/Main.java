package spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import spring.domain.Question;
import spring.services.IQuestionReader;
import spring.services.IQuestionTester;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class Main {

    @Value("${language}")
    private String language;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        final Locale LOCALE = new Locale(context.getEnvironment().getProperty("language"));
        System.out.println(context.getMessage("greeting.text", null, LOCALE));
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.nextLine();
        System.out.println(context.getMessage("hi.message", null, LOCALE) + ", " + fio);

        IQuestionReader reader = (IQuestionReader) context.getBean("questionReader");
        IQuestionTester tester = (IQuestionTester) context.getBean("questionTester");
        int score = 0;
        List<Question> questions = reader.getAll();
        for (int q = 0; q < questions.size(); q ++) {
            Question question = questions.get(q);
            System.out.println(context.getMessage("question.text", null, LOCALE) + ": " + (q + 1)  + " " + context.getMessage("question.from.word", null, LOCALE) + " " + questions.size());
            System.out.println(question.getQuestion());
            List<String> answers = question.getShuffledAnswers();
            System.out.println(context.getMessage("answers.options.text", null, LOCALE) + ": ");
            for (int i = 0; i < answers.size(); i++) {
                System.out.println(i + 1 + ". " + answers.get(i));
            }
            System.out.println(context.getMessage("chosen.option.text", null, LOCALE) + ": ");

            boolean isIncorrectAnswer = true;

            do {
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println(context.getMessage("illegal.answer.type.error.message", null, LOCALE));
                    continue;
                }
                int userAnswer = scanner.nextInt();
                isIncorrectAnswer = userAnswer <= 0 || userAnswer > answers.size();
                if (isIncorrectAnswer) {
                    System.out.println(context.getMessage("incorrect.number.message", null, LOCALE));
                    continue;
                }
                if (tester.isRightAnswer(question, answers.get(userAnswer - 1))) {
                    System.out.println(context.getMessage("right.answer.message", null, LOCALE) + "\n");
                    score++;
                } else {
                    System.out.println(context.getMessage("wrong.answer.message", null, LOCALE) + ": " + tester.getRightAnswer(question) + "\n");
                }
            } while (isIncorrectAnswer);

        }
        System.out.println(context.getMessage("questions.is.over.message", null, LOCALE) + ", " + fio);
        System.out.println(context.getMessage("result.count.message", null, LOCALE) + " " + score + " " + context.getMessage("result.from.word", null, LOCALE) + " " + questions.size() + " " + context.getMessage("result.questions.word", null, LOCALE) + "\n");
        System.out.println(context.getMessage("bye.message", null, LOCALE));
    }

    /**
     * Конфиг бандлов для поддержки разных языков
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
