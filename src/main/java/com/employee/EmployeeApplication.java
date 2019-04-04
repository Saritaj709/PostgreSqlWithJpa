package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.employee.model.BasicAuthAuthorizationInterceptor;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
public class EmployeeApplication {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		SpringApplication.run(EmployeeApplication.class, args).getBean(BasicAuthAuthorizationInterceptor.class)
				.getUsers();
	}

	/*
	 * @Bean
	 * 
	 * @ConfigurationProperties public BasicAuthAuthorizationInterceptor
	 * interceptor() { return new BasicAuthAuthorizationInterceptor(); }
	 * 
	 * public static class BasicAuthAuthorizationInterceptor { private Map<String,
	 * String> users = new HashMap<String, String>(); private Multimap<String,
	 * String> multimap = ArrayListMultimap.create(); String key="response.message";
	 * 
	 * public Map<String, String> getUsers() {
	 * System.out.println("users are "+this.users);
	 * System.out.println("multimaps "+multimap.get("users.message")); return
	 * this.users; } }
	 */

}
