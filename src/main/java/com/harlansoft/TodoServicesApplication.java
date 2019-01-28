package com.harlansoft;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// this annotation says that
	// this class is a Spring Context file
	// it enables auto configuration
	// it enables component scan: classes in packages are scanned looking for Spring annotations
	// for example, classes annotated with "RestController" will be registered as spring components,
	// and his lifecycle will be managed by the spring framework
	// NB thi is only valid for classes in SUBPACKAGES of the current package!
	// annotated classes in other sub-trees will not be detected!

@SpringBootApplication
public class TodoServicesApplication {

	public static void main(String[] args) {
		
		// it is used to run an Application contex
		// it takes an application context as input - in this case, this annotated class
		// this method returns the ApplicationContext back
		ApplicationContext context = SpringApplication.run(TodoServicesApplication.class, args);
		
//		these beans are configured via Spring Boot auto configuration
//		at startup, the spring boot fw will trigger the autoconfigure JAR
//		this will loop through all classes on the classpath
//		it will find, for example, the spring MVC jar, so it will start to configure a dispatcher servlet, view resolver...
//		see springboottutorial.com
		
		List<String> names = Arrays.asList(context.getBeanDefinitionNames());
		names.stream()
			.map(String::toString)
			.forEach(System.out::println);
	}

}

