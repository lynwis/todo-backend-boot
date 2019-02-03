package com.harlansoft.todo.app.model.todo;

import java.util.Date;

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
public class Todo {
	
	@EqualsAndHashCode.Include
	private long id;
	
	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

}
