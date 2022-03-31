package br.com.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OAuth2AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	
	@Value("${factories.oauth.clientId}")
	private String clenteID;

	@Value("${factories.oauth.clientSecvret}")
	private String clientSecret;

	@Value("${factories.oauth.redirectUris}")
	private String redirectURLs;

	@Value("${factories.oauth.accessTokenValidity}")
	private int accessTokenValidity;

	@Value("${factories.oauth.refreshTokenValidity}")
	private int refreshTokenValidity;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception{
		
		oauthServer.tokenKeyAccess("permiteAll()").checkTokenAccess("isAuthenticated()");
	}

	public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
		clients.inMemory()
		.withClient(clenteID)
		.secret(passwordEncoder.encode(clientSecret))
		.authorizedGrantTypes("password","authorization_code","refresh_tokern")
		.scopes("user_info")
		.authorities("READ_ONLY_CLIENT")
		.redirectUris(redirectURLs)
		.accessTokenValiditySeconds(accessTokenValidity)
		.refreshTokenValiditySeconds(refreshTokenValidity);
	
	}
	
	
	
}
