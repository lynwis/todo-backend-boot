package com.harlansoft.todo.app.model.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Todo {
	
//	jdbc:h2:mem:testdb
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private Long id;	// it's an accepted practice to use wrapper objects for Ids
						// like this, if an entity has a null Id, it means it still has to be persisted
	
	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

}
