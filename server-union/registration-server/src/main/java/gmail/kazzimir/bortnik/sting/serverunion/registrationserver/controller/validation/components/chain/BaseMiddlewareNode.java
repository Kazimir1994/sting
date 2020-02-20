package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain;

import java.util.Objects;

public abstract class BaseMiddlewareNode<ObjectValidations, ValidationResultNode> {
    private BaseMiddlewareNode<ObjectValidations, ValidationResultNode> baseMiddlewareNode;

    public BaseMiddlewareNode<ObjectValidations, ValidationResultNode> linkWith(BaseMiddlewareNode<ObjectValidations, ValidationResultNode> baseMiddlewareNode) {
        this.baseMiddlewareNode = baseMiddlewareNode;
        return baseMiddlewareNode;
    }

    public abstract ValidationResultNode check(ObjectValidations objectValidations);

    protected ValidationResultNode checkNext(ObjectValidations objectValidations) {
        if (Objects.isNull(baseMiddlewareNode)) {
            return null;
        }
        return baseMiddlewareNode.check(objectValidations);
    }
}
