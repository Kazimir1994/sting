package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain;

import java.util.LinkedHashSet;
import java.util.Set;

public class WrapperResultNode<ObjectValidations, E extends Enum<E>> {
    private ObjectValidations objectValidations;

    public WrapperResultNode(ObjectValidations objectValidations) {
        this.objectValidations = objectValidations;
    }

    private Set<E> resultMessages = new LinkedHashSet<>();

    public Set<E> getResultMessages() {
        return resultMessages;
    }

    public boolean add(E value) {
        return resultMessages.add(value);
    }

    public ObjectValidations getObjectValidations() {
        return objectValidations;
    }
}
