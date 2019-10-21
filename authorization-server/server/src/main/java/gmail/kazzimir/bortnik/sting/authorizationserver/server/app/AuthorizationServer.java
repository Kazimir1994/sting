package gmail.kazzimir.bortnik.sting.authorizationserver.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "gmail.kazzimir.bortnik.sting.authorizationserver")
@EntityScan(basePackages = "gmail.kazzimir.bortnik.sting.authorizationserver.repository.model")
@EnableJpaRepositories(basePackages = "gmail.kazzimir.bortnik.sting.authorizationserver.repository.impl")
public class AuthorizationServer {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServer.class, args);
    }
}
