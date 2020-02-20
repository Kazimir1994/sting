package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.WrapperResultNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation.ValidationConstants.MAX_PORT;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation.ValidationConstants.MIN_PORT;
import static gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum.NONEXISTENT_PORT;

public class CheckPortFormMiddlewareNode extends BaseMiddlewareNode<IpPortDTO, ValidationResultNodeMessageEnum> {
    private static final Logger logger = LoggerFactory.getLogger(CheckPortFormMiddlewareNode.class);

    @Override
    public WrapperResultNode<IpPortDTO, ValidationResultNodeMessageEnum> check(WrapperResultNode<IpPortDTO, ValidationResultNodeMessageEnum> wrapperResultNode) {
        logger.info(CheckPortFormMiddlewareNode.class.getName() + " :-> {}", wrapperResultNode.getObjectValidations());
        int port = wrapperResultNode.getObjectValidations().getPort();
        if (port >= MIN_PORT && port <= MAX_PORT) {
            return checkNext(wrapperResultNode);
        }
        wrapperResultNode.add(NONEXISTENT_PORT);
        return wrapperResultNode;
    }
}
