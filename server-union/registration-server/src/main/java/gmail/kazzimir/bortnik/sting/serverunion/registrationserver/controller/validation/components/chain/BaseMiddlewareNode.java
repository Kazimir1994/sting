package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain;

public abstract class BaseMiddlewareNode<T> {
    private BaseMiddlewareNode<T> baseMiddlewareNode;

    public BaseMiddlewareNode<T> linkWith(BaseMiddlewareNode<T> baseMiddlewareNode) {
        this.baseMiddlewareNode = baseMiddlewareNode;
        return baseMiddlewareNode;
    }

    public abstract boolean check(T object);

    protected final boolean checkNext(T object) {
        if (baseMiddlewareNode == null) {
            return true;
        }
        return baseMiddlewareNode.check(object);
    }
}
