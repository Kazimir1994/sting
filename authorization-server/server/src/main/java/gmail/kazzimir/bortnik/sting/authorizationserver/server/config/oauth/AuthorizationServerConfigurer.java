package gmail.kazzimir.bortnik.sting.authorizationserver.server.config.oauth;

import gmail.kazzimir.bortnik.sting.authorizationserver.server.config.oauth.component.CustomDefaultAccessTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;

import static gmail.kazzimir.bortnik.sting.authorizationserver.server.config.constants.URLConstants.CUSTOM_PATH;
import static gmail.kazzimir.bortnik.sting.authorizationserver.server.config.constants.URLConstants.DEFAULT_PATH;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    @Value("${oauth.client.secret}")
    private String signingKey;
    private static final String TOKEN_KEY_ACCESS = "permitAll()";
    private static final String CHECK_TOKEN_ACCESS = "isAuthenticated()";

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final DataSource dataSource;
    private final CustomDefaultAccessTokenConverter customDefaultAccessTokenConverter;

    @Autowired
    public AuthorizationServerConfigurer(PasswordEncoder passwordEncoder,
                                         AuthenticationManager authenticationManager,
                                         DataSource dataSource, CustomDefaultAccessTokenConverter customDefaultAccessTokenConverter) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.dataSource = dataSource;
        this.customDefaultAccessTokenConverter = customDefaultAccessTokenConverter;
    }

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) {
        security.passwordEncoder(this.passwordEncoder).tokenKeyAccess(TOKEN_KEY_ACCESS)
                .checkTokenAccess(CHECK_TOKEN_ACCESS);
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(this.dataSource).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .pathMapping(DEFAULT_PATH, CUSTOM_PATH)
                .tokenStore(jdbcTokenStore())
                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setAccessTokenConverter(customDefaultAccessTokenConverter);
        jwtAccessTokenConverter.setSigningKey(signingKey);
        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }
}
