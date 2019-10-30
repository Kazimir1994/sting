package gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.ResourceServersIdentifier;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.Converter;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.ResourceServersIdentifierDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterResourceServersIdentifier implements Converter<ResourceServersIdentifierDTO, ResourceServersIdentifier> {

    @Override
    public ResourceServersIdentifierDTO toDTO(ResourceServersIdentifier resourceServersIdentifier) {
        ResourceServersIdentifierDTO resourceServersIdentifierDTO = new ResourceServersIdentifierDTO();
        resourceServersIdentifierDTO.setId(resourceServersIdentifier.getId());
        resourceServersIdentifierDTO.setIdentifier(resourceServersIdentifier.getIdentifier());
        return resourceServersIdentifierDTO;
    }

    @Override
    public ResourceServersIdentifier fromDTO(ResourceServersIdentifierDTO resourceServersIdentifierDTO) {
        throw new UnsupportedOperationException();
    }
}
