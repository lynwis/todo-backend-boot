package com.harlansoft.todo.app.resources.restful.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harlansoft.todo.app.model.todo.Todo;
import com.harlansoft.todo.app.model.todo.repository.TodoJpaRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoJPAResource {
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;

//	we answer with the list of todos found
//	the http status is by default "200 Success"
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
//		return hardCodedService.findAll();
		return todoJpaRepository.findByUsername(username);
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,
			@PathVariable long id) {
//		return hardCodedService.findById(id);
		return todoJpaRepository.findById(id).get();
	}
	
//	tipically, a delete method returns either "success" or "no content"
//	in the latter case, we return a ResponseEntity with no content
//	if there is no entity matching the request, we return a NOT FOUND
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String username,
			@PathVariable long id) {
//		Todo todo = hardCodedService.deleteById(id);
//		return todo != null ? ResponseEntity.noContent().build()
//				: ResponseEntity.notFound().build();
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
//	Edit/update Todo
//	we are binding the request body to a Todo object
//	NB to bind to a RequestBody the object needs a default constructor
//	the update returns an OK status and the content created in the response body
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,
			@PathVariable long id, @RequestBody Todo todo) {
//		Todo updatedTodo = hardCodedService.save(todo);
//		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
		Todo updatedTodo = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}
	
//	Create new Todo item
	@PostMapping("/jpa/users/{username}/todos/")
	public ResponseEntity<Todo> addTodo(@PathVariable String username,
			@RequestBody Todo todo) {
		
		Todo createdTodo = todoJpaRepository.save(todo);
		
//		we're returning back the URL of the newly created resource
//		/users/{username}/todos/<new-id>
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(createdTodo.getId()).toUri();
		
//		we return back a response with NO BODY and the CREATED HTTP status
//		with the uri of the new resource
		return ResponseEntity.created(uri).build();
		
	}
	
}





