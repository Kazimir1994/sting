package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import java.io.Serializable;

public class BaseDTO implements Serializable {
    private static final long serialVersionUID = -5886369982095687772L;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
