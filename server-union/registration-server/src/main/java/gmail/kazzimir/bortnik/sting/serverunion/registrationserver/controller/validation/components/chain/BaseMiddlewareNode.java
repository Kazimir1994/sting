package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain;

import java.util.Objects;

public abstract class BaseMiddlewareNode<T, E extends Enum<E>> {
    private BaseMiddlewareNode<T, E> baseMiddlewareNode;

    public BaseMiddlewareNode<T, E> linkWith(BaseMiddlewareNode<T, E> baseMiddlewareNode) {
        this.baseMiddlewareNode = baseMiddlewareNode;
        return baseMiddlewareNode;
    }

    public abstract WrapperResultNode<T, E> check(WrapperResultNode<T, E> wrapperResultNode);

    protected WrapperResultNode<T, E> checkNext(WrapperResultNode<T, E> wrapperResultNode) {

        if (Objects.isNull(baseMiddlewareNode)) {
            return wrapperResultNode;
        }
        return baseMiddlewareNode.check(wrapperResultNode);
    }
}
