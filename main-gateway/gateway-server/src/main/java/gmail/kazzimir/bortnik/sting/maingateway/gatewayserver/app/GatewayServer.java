package gmail.kazzimir.bortnik.sting.maingateway.gatewayserver.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "gmail.kazzimir.bortnik.sting.maingateway")
@EnableMongoRepositories("gmail.kazzimir.bortnik.sting.maingateway.gatewayrepository.impl")
public class GatewayServer  {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }
}
