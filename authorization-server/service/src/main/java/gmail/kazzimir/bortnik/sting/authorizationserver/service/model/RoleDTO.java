package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import java.util.Collection;

public class RoleDTO extends BaseDTO {
    private String name;
    private Collection<PermissionDTO> permissions;

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

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
