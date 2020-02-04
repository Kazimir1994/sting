package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation.ValidationConstants.MaxPort;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation.ValidationConstants.MinPort;

public class CheckPortFormMiddlewareNode extends BaseMiddlewareNode<IpPortDTO> {
    private static final Logger logger = LoggerFactory.getLogger(CheckPortFormMiddlewareNode.class);
    @Override
    public boolean check(IpPortDTO ipPortDTO) {
        logger.info("CheckPortFormMiddlewareNode :-> {}", ipPortDTO);
        int port = ipPortDTO.getPort();
        if (port >= MinPort && port <= MaxPort) {
            return checkNext(ipPortDTO);
        }
        return false;
    }
}
