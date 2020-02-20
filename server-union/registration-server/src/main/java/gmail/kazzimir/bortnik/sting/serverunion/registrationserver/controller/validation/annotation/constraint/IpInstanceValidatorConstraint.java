package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.annotation.constraint;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.annotation.IpInstanceValidator;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.BaseMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.WrapperResultNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization.CheckIpFormMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization.CheckPortFormMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.realization.VerifyIpAddressAvailabilityMiddlewareNode;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IpInstanceValidatorConstraint implements ConstraintValidator<IpInstanceValidator, IpPortDTO> {
    private final RestTemplate restTemplate;

    @Autowired
    public IpInstanceValidatorConstraint(@Qualifier("restTemplateServerUnion") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean isValid(IpPortDTO ipPortDTO, ConstraintValidatorContext constraintValidatorContext) {
        BaseMiddlewareNode<IpPortDTO, ValidationResultNodeMessageEnum> baseMiddlewareNode = createValidatorChain();
        WrapperResultNode<IpPortDTO, ValidationResultNodeMessageEnum> resultValid =
                baseMiddlewareNode.check(new WrapperResultNode<>(ipPortDTO));
        return false;
    }

    private BaseMiddlewareNode<IpPortDTO, ValidationResultNodeMessageEnum> createValidatorChain() {
        CheckIpFormMiddlewareNode checkIpFormMiddlewareNode = new CheckIpFormMiddlewareNode();
        checkIpFormMiddlewareNode
                .linkWith(new CheckPortFormMiddlewareNode())
                .linkWith(new VerifyIpAddressAvailabilityMiddlewareNode(restTemplate));
        return checkIpFormMiddlewareNode;
    }
}