package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

public class PermissionDTO extends BaseDTO {
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
