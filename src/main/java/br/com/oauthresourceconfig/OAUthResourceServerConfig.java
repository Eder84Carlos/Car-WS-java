package br.com.oauthresourceconfig;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class OAUthResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests()
		.antMatchers("/api/**").authenticated()
		.antMatchers("/").permitAll();
	}

}
