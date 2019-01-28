package com.harlansoft.resources.restful.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.harlansoft.resources.restful.helloworld.bean.HelloWorldBean;

// this class is a Spring Controller, i.e. it handles http requests
// specifically, this is a REST controller, so it handles REST http requests
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldResource {
	
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		if (System.currentTimeMillis() % 2 == 0)
			return new HelloWorldBean("* Hello World! *");
		else
			throw new RuntimeException("Bad luck!");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s!", name));
	}

}
