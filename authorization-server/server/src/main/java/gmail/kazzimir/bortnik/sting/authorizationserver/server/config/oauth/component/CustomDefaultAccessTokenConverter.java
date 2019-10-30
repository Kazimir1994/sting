package gmail.kazzimir.bortnik.sting.authorizationserver.server.config.oauth.component;

import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.CustomUserDetails;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.ResourceServersIdentifierDTO;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.RoleDTO;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomDefaultAccessTokenConverter extends DefaultAccessTokenConverter {
    private static final String GRANT_TYPE_PASSWORD = "password";

    @SuppressWarnings("unchecked")
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> response = (Map<String, Object>) super.convertAccessToken(token, authentication);
        String grantType = authentication.getOAuth2Request().getGrantType();

        if (GRANT_TYPE_PASSWORD.equals(grantType)) {
            CustomUserDetails customuserDetails = (CustomUserDetails) authentication.getPrincipal();
            List<String> resourceServers = getResourceServersIdentifier(customuserDetails.getRoles());
            response.put(AUD, resourceServers);
        }
        return response;
    }

    private List<String> getResourceServersIdentifier(Collection<RoleDTO> roleDTOS) {
        return roleDTOS.stream().map(RoleDTO::getResourceServersIdentifiers)
                .map(this::getListIdentifier)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<String> getListIdentifier(Collection<ResourceServersIdentifierDTO> identifierDTOS) {
        return identifierDTOS.stream()
                .map(ResourceServersIdentifierDTO::getIdentifier)
                .collect(Collectors.toList());
    }
}
