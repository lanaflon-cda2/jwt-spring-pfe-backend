package org.isi.service;

import java.util.List;

import org.isi.entities.AppRole;
import org.isi.entities.AppUser;
import org.isi.entities.Vlan;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String roleName);
	public AppUser findUserByUsername( String username);
	public AppUser findone(String username);
	public AppUser update(AppUser appuser);
	List<AppUser> findAll();
	

}
