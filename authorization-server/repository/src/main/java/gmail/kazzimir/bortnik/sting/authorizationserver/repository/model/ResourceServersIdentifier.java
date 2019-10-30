package gmail.kazzimir.bortnik.sting.authorizationserver.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "resource_servers_identifier")
public class ResourceServersIdentifier extends BaseEntity {
    @Column(name = "identifier")
    private String identifier;

    @ManyToMany(mappedBy = "permission")
    private Collection<Role> resourceServersIdentifiers;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Collection<Role> getResourceServersIdentifiers() {
        return resourceServersIdentifiers;
    }

    public void setResourceServersIdentifiers(Collection<Role> resourceServersIdentifiers) {
        this.resourceServersIdentifiers = resourceServersIdentifiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceServersIdentifier that = (ResourceServersIdentifier) o;
        return identifier.equals(that.identifier) &&
                resourceServersIdentifiers.equals(that.resourceServersIdentifiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, resourceServersIdentifiers);
    }
}
