package gmail.kazzimir.bortnik.sting.telegramresourceserver.telegramserver.controllers.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlerTest {
    private final static Logger logger = LoggerFactory.getLogger(ControlerTest.class);


    @GetMapping("/test")
    public ResponseEntity<Object> getArticles() {

        return new ResponseEntity<>("SDSD", HttpStatus.OK);
    }
}
