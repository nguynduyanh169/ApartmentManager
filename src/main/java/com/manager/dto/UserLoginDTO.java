package com.manager.dto;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserLoginDTO {

	private String email;
	private String password;
	private String[] role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRole() {
		return role;
	}

	public void setRole(String[] role) {
		this.role = role;
	}
	
	public List<GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (String role : role) {
	      authorities.add(new SimpleGrantedAuthority(role));
	    }
	    return authorities;
	  }


}
