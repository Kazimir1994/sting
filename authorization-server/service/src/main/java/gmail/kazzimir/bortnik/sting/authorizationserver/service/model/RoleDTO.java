package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import java.io.Serializable;
import java.util.Collection;

public class RoleDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -4300851853719841762L;
    private String name;
    private Collection<PermissionDTO> permissions;
    private Collection<ResourceServersIdentifierDTO> resourceServersIdentifiers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<PermissionDTO> permissions) {
        this.permissions = permissions;
    }

    public Collection<ResourceServersIdentifierDTO> getResourceServersIdentifiers() {
        return resourceServersIdentifiers;
    }

    public void setResourceServersIdentifiers(Collection<ResourceServersIdentifierDTO> resourceServersIdentifiers) {
        this.resourceServersIdentifiers = resourceServersIdentifiers;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                "name='" + resourceServersIdentifiers + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
