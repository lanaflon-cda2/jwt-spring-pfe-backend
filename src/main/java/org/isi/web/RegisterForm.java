package org.isi.web;

import java.util.ArrayList;
import java.util.Collection;

import org.isi.entities.AppRole;

public class RegisterForm {
	private String username ;
	private String password ;
	private String repassword ;
	private Collection<AppRole> roles = new ArrayList<>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}

}
