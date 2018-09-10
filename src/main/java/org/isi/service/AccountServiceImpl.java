package org.isi.service;

import java.util.List;

import org.isi.dao.RoleRepository;
import org.isi.dao.UserRepository;
import org.isi.entities.AppRole;
import org.isi.entities.AppUser;
import org.isi.entities.Vlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional

public class AccountServiceImpl implements  AccountService {
	@Autowired
	private BCryptPasswordEncoder  bcryptPasswordEncoder ;
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	
	private RoleRepository  roleRepository ;

	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW=bcryptPasswordEncoder.encode(user.getPassword());
		
		user.setPassword(hashPW);
		
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role=roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(username);
		user.getRoles().add(role);
		
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		
		return userRepository.findByUsername(username) ;
	}
	
	@Override
	public List<AppUser> findAll(){
		return userRepository.findAll();
		
		
	}
	@Override
	public AppUser findone(String username) {
		return userRepository.findByUsername(username);
		
	}
    @Override
    public AppUser update(AppUser appuser) {
    	return userRepository.save(appuser);
    }
}
