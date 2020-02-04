package gmail.kazzimir.bortnik.sting.telegramresourceserver.telegramserver.controllers.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ControlerTest {
    private final static Logger logger = LoggerFactory.getLogger(ControlerTest.class);


    @GetMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getArticles() {
        return Flux.just("rwerwer", "werwerwe", "werwerwer", "werwerwer");
    }
}
