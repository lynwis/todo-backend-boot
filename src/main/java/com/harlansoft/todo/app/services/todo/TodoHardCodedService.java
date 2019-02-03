package com.harlansoft.todo.app.services.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harlansoft.todo.app.model.todo.Todo;

@Service
public class TodoHardCodedService {
	
	private static int idCounter;
	private static final List<Todo> todos;
	static {
		idCounter = 0;
		todos = new ArrayList<>();
		todos.add(new Todo(++idCounter, "harlan", "Learn Typescript!", new Date(), false));
		todos.add(new Todo(++idCounter, "harlan", "Learn Angular!", new Date(), false));
		todos.add(new Todo(++idCounter, "harlan", "Learn Microservices!", new Date(), false));

	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		if (todo.getId() <= 0) {
			todo.setId(++idCounter);
			todos.add(todo);
			
		}else {
			deleteById(todo.getId());
			todos.add(todo);
			
		}
		
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo != null) todos.remove(todo);
		return todo;
	}

	public Todo findById(long id) {
		return todos.stream()
			.filter(todo -> todo.getId() == id)
			.findAny()
			.orElse(null);
	}

}
