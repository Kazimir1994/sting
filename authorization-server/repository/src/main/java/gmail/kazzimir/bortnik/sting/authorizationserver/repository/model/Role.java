package gmail.kazzimir.bortnik.sting.authorizationserver.repository.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<Account> account;

    @ManyToMany
    @JoinTable(
            name = "roles_permission",
            joinColumns = @JoinColumn(
                    name = "roles_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private Collection<Permission> permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Account> getAccount() {
        return account;
    }

    public void setAccount(Collection<Account> account) {
        this.account = account;
    }

    public Collection<Permission> getPermission() {
        return permission;
    }

    public void setPermission(Collection<Permission> permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return getId().equals(role.getId()) &&
                name.equals(role.name) &&
                account.equals(role.account) &&
                permission.equals(role.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, account, permission);
    }
}
