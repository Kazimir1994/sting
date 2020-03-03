package gmail.kazzimir.bortnik.exceptionfactory.configuration;

import gmail.kazzimir.bortnik.exceptionfactory.impl.ExceptionGeneratorUtils;
import gmail.kazzimir.bortnik.exceptionfactory.settings.CustomErrorAttributes;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionAutoconfigure {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(ExceptionGeneratorUtils.class)
    public CustomErrorAttributes customErrorAttributes() {
        return new CustomErrorAttributes();
    }
}
