package com.harlansoft.todo.app.resources.restful.helloworld.bean;

import lombok.Getter;
import lombok.Setter;

public class HelloWorldBean {

	@Getter @Setter
	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}

}
