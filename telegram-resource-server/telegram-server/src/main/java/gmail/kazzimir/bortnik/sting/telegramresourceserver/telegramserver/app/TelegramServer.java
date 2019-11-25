package gmail.kazzimir.bortnik.sting.telegramresourceserver.telegramserver.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "gmail.kazzimir.bortnik.sting.telegramresourceserver")
@EntityScan(basePackages = "gmail.kazzimir.bortnik.sting.telegramresourceserver.telegramrepository.model")
//@EnableJpaRepositories(basePackages = "gmail.kazzimir.bortnik.sting.telegramresourceserver.telegramrepository.impl")
public class TelegramServer {
    public static void main(String[] args) {
        SpringApplication.run(TelegramServer.class, args);
    }
}