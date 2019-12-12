package gmail.kazzimir.bortnik.sting.maingateway.maingatewayserver.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "gmail.kazzimir.bortnik.sting.maingateway")
@EnableMongoRepositories("gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.impl")
public class MainGatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(MainGatewayServer.class, args);
    }
}