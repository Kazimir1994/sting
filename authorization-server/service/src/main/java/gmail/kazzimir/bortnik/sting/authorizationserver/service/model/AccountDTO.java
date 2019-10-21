package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import java.io.Serializable;
import java.util.Collection;

public class AccountDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 9048577667984992327L;
    private String password;

    private String name;

    private String surname;

    private String email;

    private Collection<RoleDTO> roles;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public Collection<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleDTO> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id='" + getId() + '\'' +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
