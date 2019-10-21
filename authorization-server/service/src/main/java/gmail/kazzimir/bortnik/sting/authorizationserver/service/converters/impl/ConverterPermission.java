package gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Permission;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.Converter;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.PermissionDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterPermission implements Converter<PermissionDTO, Permission> {
    @Override
    public PermissionDTO toDTO(Permission permission) {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setId(permission.getId());
        permissionDTO.setName(permission.getName());
        return permissionDTO;
    }

    @Override
    public Permission fromDTO(PermissionDTO permissionDTO) {
        throw new UnsupportedOperationException();
    }
}
