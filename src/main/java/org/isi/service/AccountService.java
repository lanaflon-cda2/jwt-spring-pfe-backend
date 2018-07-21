package org.isi.service;

import org.isi.entities.AppRole;
import org.isi.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String roleName);
	public AppUser findUserByUsername( String username);
	

}
