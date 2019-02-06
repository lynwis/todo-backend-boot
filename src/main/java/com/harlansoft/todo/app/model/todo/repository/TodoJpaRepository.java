package com.harlansoft.todo.app.model.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harlansoft.todo.app.model.todo.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findByUsername(String username);
	
}
