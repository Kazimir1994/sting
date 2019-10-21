package gmail.kazzimir.bortnik.sting.authorizationserver.repository.model;


import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Account")
public class Account extends BaseEntity {

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "user_surname", nullable = false)
    private String userSurname;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(
                    name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "roles_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        Account account = (Account) o;
        return getId().equals(account.getId()) &&
                password.equals(account.password) &&
                userName.equals(account.userName) &&
                userSurname.equals(account.userSurname) &&
                email.equals(account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), password, userName, userSurname, email);
    }

}
