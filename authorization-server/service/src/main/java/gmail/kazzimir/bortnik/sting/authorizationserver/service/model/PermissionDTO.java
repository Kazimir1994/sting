package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import java.io.Serializable;

public class PermissionDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -6847751459271796643L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PermissionDTO{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
