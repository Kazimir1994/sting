package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.WrapperResultNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation.ValidationConstants.REGEX_IP;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum.NOT_MATCH;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum.NULL;

public class CheckIpFormMiddlewareNode extends BaseMiddlewareNode<IpPortDTO, ValidationResultNodeMessageEnum> {
    private static final Logger logger = LoggerFactory.getLogger(CheckIpFormMiddlewareNode.class);

    @Override
    public WrapperResultNode<IpPortDTO, ValidationResultNodeMessageEnum> check(WrapperResultNode<IpPortDTO, ValidationResultNodeMessageEnum> wrapperResultNode) {
        logger.info(CheckIpFormMiddlewareNode.class.getName() + " :-> {}", wrapperResultNode.getObjectValidations());
        if (Objects.nonNull(wrapperResultNode.getObjectValidations())) {
            String ip = wrapperResultNode.getObjectValidations().getIp();
            boolean ipIsValid = ip.matches(REGEX_IP);
            if (ipIsValid) {
                return checkNext(wrapperResultNode);
            } else {
                wrapperResultNode.add(NOT_MATCH);
                return wrapperResultNode;
            }
        }
        wrapperResultNode.add(NULL);
        return wrapperResultNode;
    }
}
