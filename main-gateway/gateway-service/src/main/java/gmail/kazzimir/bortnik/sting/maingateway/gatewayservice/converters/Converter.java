package gmail.kazzimir.bortnik.sting.maingateway.gatewayservice.converters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<ObjectDTO, Object> {
    ObjectDTO toDTO(Object object);

    Object fromDTO(ObjectDTO objectDTO);

    default List<ObjectDTO> listToDTO(final Collection<Object> objectCollection) {
        return objectCollection.stream().map(this::toDTO).collect(Collectors.toList());
    }

    default List<Object> listFromDTO(final Collection<ObjectDTO> objectCollection) {
        return objectCollection.stream().map(this::fromDTO).collect(Collectors.toList());
    }
}