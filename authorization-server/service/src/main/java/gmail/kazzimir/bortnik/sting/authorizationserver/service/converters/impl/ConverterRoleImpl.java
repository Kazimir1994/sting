package gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Permission;
import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.ResourceServersIdentifier;
import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Role;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.Converter;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.PermissionDTO;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.ResourceServersIdentifierDTO;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterRoleImpl implements Converter<RoleDTO, Role> {
    private final Converter<PermissionDTO, Permission> permissionConverter;
    private final Converter<ResourceServersIdentifierDTO, ResourceServersIdentifier> resourceServersIdentifierConverter;

    @Autowired
    public ConverterRoleImpl(Converter<PermissionDTO, Permission> permissionConverter,
                             Converter<ResourceServersIdentifierDTO, ResourceServersIdentifier> resourceServersIdentifierConverter) {
        this.permissionConverter = permissionConverter;
        this.resourceServersIdentifierConverter = resourceServersIdentifierConverter;
    }

    @Override
    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        List<PermissionDTO> permissionDTOS = permissionConverter.listToDTO(role.getPermission());
        roleDTO.setPermissions(permissionDTOS);
        List<ResourceServersIdentifierDTO> resourceServersIdentifierDTOS =
                resourceServersIdentifierConverter.listToDTO(role.getResourceServersIdentifiers());
        roleDTO.setResourceServersIdentifiers(resourceServersIdentifierDTOS);
        return roleDTO;
    }

    @Override
    public Role fromDTO(RoleDTO roleDTO) {
        throw new UnsupportedOperationException();
    }
}
