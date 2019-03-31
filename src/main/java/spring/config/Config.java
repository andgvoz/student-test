package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.services.QuestionReader;
import spring.services.QuestionTester;

@Configuration
public class Config {

    @Bean
    public QuestionReader questionReader() {
        return new QuestionReader("questions.csv");
    }

    @Bean
    public QuestionTester questionTester() {
        return new QuestionTester();
    }
}
