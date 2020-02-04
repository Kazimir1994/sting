package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.api;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.InstanceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.message.logger.MessageLogger.MESSAGE_LOG_REGISTRATION_SERVER;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.url.ApiUrl.API_URL_REGISTRATION;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.url.ApiUrl.API_URL_V1;

@RestController
@RequestMapping(API_URL_V1)
public class ServerUnionController {
    private static final Logger logger = LoggerFactory.getLogger(ServerUnionController.class);

    @PostMapping(API_URL_REGISTRATION)
    public ResponseEntity registrationInstance(@Valid @RequestBody InstanceDTO instanceDTO) {
        logger.info(MESSAGE_LOG_REGISTRATION_SERVER, instanceDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
