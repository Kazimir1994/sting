package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.configuration;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.ExceptionHandlers.ServerUnionExceptionHandlers;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.api.ServerUnionController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RegistrationServerAutoConfigure {
    @Bean
    public ServerUnionController serverUnionController() {
        return new ServerUnionController();
    }

    @Bean(name = "restTemplateServerUnion")
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setReadTimeout(Duration.ofSeconds(3))
                .setConnectTimeout(Duration.ofSeconds(3))
                .build();
    }

    @Bean
    public ServerUnionExceptionHandlers serverUnionExceptionHandlers() {
        return new ServerUnionExceptionHandlers();
    }
}
