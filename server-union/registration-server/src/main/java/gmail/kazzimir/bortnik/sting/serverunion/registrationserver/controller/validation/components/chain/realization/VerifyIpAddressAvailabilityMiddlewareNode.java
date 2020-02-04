package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class VerifyIpAddressAvailabilityMiddlewareNode extends BaseMiddlewareNode<IpPortDTO> {
    private static final Logger logger = LoggerFactory.getLogger(CheckPortFormMiddlewareNode.class);
    private RestTemplate restTemplateMock;

    public VerifyIpAddressAvailabilityMiddlewareNode(RestTemplate restTemplate) {
        this.restTemplateMock = restTemplate;
    }

    @Override
    public boolean check(IpPortDTO ipPortDTO) {
        logger.info("VerifyIpAddressAvailabilityMiddlewareNode :->{}", ipPortDTO);
        try {
            ResponseEntity resp = restTemplateMock.getForEntity(
                    "http://" + ipPortDTO.getIp() + ":" + ipPortDTO.getPort() + "/employee",
                    null);

        } catch (RestClientException e) {

        }
        return false;
    }
}
