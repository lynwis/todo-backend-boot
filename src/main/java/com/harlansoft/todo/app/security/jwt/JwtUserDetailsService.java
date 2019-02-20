package com.harlansoft.todo.app.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harlansoft.todo.app.model.user.repository.JwtUserDetailsRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private JwtUserDetailsRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUserDetails userDetails = userRepository.findByUsername(username);
		
		if (userDetails == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		
		return userDetails;
	}
	
}
