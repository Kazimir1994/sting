package gmail.kazzimir.bortnik.sting.authorizationserver.server.config.oauth.model;

import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.CustomUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class CustomerJwtAccessTokenConverter extends JwtAccessTokenConverter {
    private static final String GRANT_TYPE = "password";

    public CustomerJwtAccessTokenConverter(String key) {
        super.setSigningKey(key);
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String grantType = authentication.getOAuth2Request().getGrantType();
        switch (grantType) {
            case GRANT_TYPE: {
                CustomUserDetails customuserDetails = (CustomUserDetails) authentication.getPrincipal();
                final Map<String, Object> additionalInfo = new HashMap<>();
                additionalInfo.put("account_id", customuserDetails.getId());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                break;
            }
        }
        accessToken = super.enhance(accessToken, authentication);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(new HashMap<>());
        return accessToken;
    }
}
