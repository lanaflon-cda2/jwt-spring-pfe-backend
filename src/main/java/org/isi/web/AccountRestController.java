package org.isi.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.isi.entities.AppUser;
import org.isi.entities.Vlan;
import org.isi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AccountRestController {
	@Autowired
	private AccountService accountService ; 
	
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm ) {
		if (!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("You must confirm your password ");
		
		AppUser user = accountService.findUserByUsername(userForm.getUsername());
		if (user!=null) throw new RuntimeException("l utilisateur existe dejà");
		
		AppUser appUser = new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		
		
		
		
		 accountService.saveUser(appUser);
		 accountService.addRoleToUser(userForm.getUsername(),"USER");
		
		 return appUser;
	}
	@PostMapping("/promotetoadmin")
	public ResponseEntity<AppUser> update(@Valid @RequestBody AppUser appuser ) {
	
		//return  taskRepository.save(t);
		
		
		 AppUser user = accountService.update(appuser);
		 
		 
		 
		 user.setPassword(appuser.getPassword());
		 accountService.addRoleToUser(user.getUsername(),"ADMIN");
		
	
		 return new ResponseEntity<AppUser>(user ,HttpStatus.OK) ;
	}
	@GetMapping("/user")
	public ResponseEntity<List<AppUser>> listUsers(){
		
		
	List<AppUser>  appuser = accountService.findAll();
	return new ResponseEntity<List<AppUser>> (appuser,HttpStatus.OK);
	
		
	}
	//afficher un User 
	@GetMapping("/user/{username}")
	public ResponseEntity<AppUser> finduser(@PathVariable(value="username")String username){
		
		
		
		AppUser user =accountService.findone(username);
		 return new ResponseEntity<AppUser>(user ,HttpStatus.OK) ;
		
	}

}
