
package com.employee.model;

import java.util.HashMap;
import java.util.Map;

public class BasicAuthAuthorizationInterceptor {
	private Map<String, String> users = new HashMap<String, String>();

	public Map<String, String> getUsers() {
		System.out.println("response are :" + this.users);
		return this.users;
	}
}
