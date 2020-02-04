package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation.ValidationConstants.regexpIp;

public class CheckIpFormMiddlewareNode extends BaseMiddlewareNode<IpPortDTO> {
    private static final Logger logger = LoggerFactory.getLogger(CheckIpFormMiddlewareNode.class);

    @Override
    public boolean check(IpPortDTO ipPortDTO) {
        logger.info("CheckIpFormMiddlewareNode :-> {}", ipPortDTO);
        if (Objects.nonNull(ipPortDTO)) {
            String ip = ipPortDTO.getIp();
            if (Objects.nonNull(ip)) {
                boolean ipIsValid = ip.matches(regexpIp);
                if (ipIsValid) {
                    return checkNext(ipPortDTO);
                }
            }
        }
        return false;
    }
}
