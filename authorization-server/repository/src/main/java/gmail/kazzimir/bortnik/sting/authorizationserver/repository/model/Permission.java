package gmail.kazzimir.bortnik.sting.authorizationserver.repository.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "permission")
    private Collection<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return getId().equals(that.getId()) &&
                name.equals(that.name) &&
                roles.equals(that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, roles);
    }
}
