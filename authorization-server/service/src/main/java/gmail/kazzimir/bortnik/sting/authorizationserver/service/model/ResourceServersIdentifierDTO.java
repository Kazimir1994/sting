package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import java.io.Serializable;

public class ResourceServersIdentifierDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 4013345526980646034L;

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "ResourceServersIdentifierDTO{" +
                "id='" + super.getId() + '\'' +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
