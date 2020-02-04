package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.annotation.IpInstanceValidator;

public class InstanceDTO {
    private String id;

    @IpInstanceValidator
    private IpPortDTO ipPortDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IpPortDTO getIpPortDTO() {
        return ipPortDTO;
    }

    public void setIpPortDTO(IpPortDTO ipPortDTO) {
        this.ipPortDTO = ipPortDTO;
    }

    @Override
    public String toString() {
        return "InstanceDTO{" +
                "id='" + id + '\'' +
                ", ipPortDTO=" + ipPortDTO +
                '}';
    }
}
