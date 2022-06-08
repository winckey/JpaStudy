package spa.sub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spa.sub.api.service.ValidationCheck;

@Configuration
public class BeanConfiguration {

    @Bean
    public ValidationCheck validationCheck(){
        return new ValidationCheck();
    }

}
