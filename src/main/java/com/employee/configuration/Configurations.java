
package com.employee.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.model.BasicAuthAuthorizationInterceptor;

@Configuration
public class Configurations {

	@Bean
	@ConfigurationProperties(prefix="response")
	public BasicAuthAuthorizationInterceptor interceptor() {
		return new BasicAuthAuthorizationInterceptor();
	}
	
	/*
	 * @Bean public Validator validatorFactory() { return new
	 * LocalValidatorFactoryBean(); }
	 */
}
