package com.harlansoft.todo.app.model.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harlansoft.todo.app.security.jwt.JwtUserDetails;

public interface JwtUserDetailsRepository extends JpaRepository<JwtUserDetails, Long> {
	
	public JwtUserDetails findByUsername(String username);

}
