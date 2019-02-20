package com.harlansoft.todo.app.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "JWT_USR_DETAILS")
public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = 5155720064139820502L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String role;
	
	@Transient
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(Long id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));

		this.authorities = authorities;
	}

	@Transient
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}
//
//	@Override
//	public String getUsername() {
//		return username;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}

}
