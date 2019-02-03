package com.harlansoft.todo.app.resources.restful.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harlansoft.todo.app.resources.restful.security.bean.AuthenticationBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationResource {
	
//	we'll be using this url to check authentication
	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorld() {
		return new AuthenticationBean("You are authenticated");
	}

}
