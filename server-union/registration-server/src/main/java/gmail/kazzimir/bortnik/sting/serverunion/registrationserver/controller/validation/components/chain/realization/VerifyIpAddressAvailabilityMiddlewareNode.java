package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum.IP_ADDRESS_NOT_AVAILABLE;

public class VerifyIpAddressAvailabilityMiddlewareNode extends BaseMiddlewareNode<IpPortDTO, ValidationResultNodeMessageEnum> {
    private static final Logger logger = LoggerFactory.getLogger(VerifyIpAddressAvailabilityMiddlewareNode.class);
    private RestTemplate restTemplateMock;

    public VerifyIpAddressAvailabilityMiddlewareNode(RestTemplate restTemplate) {
        this.restTemplateMock = restTemplate;
    }

    @Override
    public ValidationResultNodeMessageEnum check(IpPortDTO ipPortDTO) {
        logger.info(VerifyIpAddressAvailabilityMiddlewareNode.class.getName() + " :->{}", ipPortDTO);
        try {
            ResponseEntity resp = restTemplateMock.getForEntity(
                    "http://" + ipPortDTO.getIp()
                            + ":" + ipPortDTO.getPort()
                            + "/check",
                    null);
            return checkNext(ipPortDTO);
        } catch (RestClientException e) {
            logger.info("Error :->{}", e.getLocalizedMessage());
        }
        return IP_ADDRESS_NOT_AVAILABLE;
    }
}
