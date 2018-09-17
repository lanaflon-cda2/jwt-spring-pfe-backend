package org.isi.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.isi.dao.BusinessCaseRepository;
import org.isi.entities.BusinessCase;
import org.isi.entities.Vlan;
import org.isi.service.BusinessCaseService;
import org.isi.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class BusinessCaseController {
	private Logger logger = LoggerFactory.getLogger(BusinessCaseController.class);
	
	@Autowired 
	private NotificationService notificationService;
	
	
	@Autowired 
	BusinessCaseService businessCaseService ;
	
	@Autowired
	BusinessCaseRepository repository ;
	
	

//creation de Business Case 
	@PostMapping("/businesscase")
	public ResponseEntity<BusinessCase>  save(@RequestBody BusinessCase businessCase) {
	
		if (businessCase==null)
		{throw new NullPointerException("businessCase object cannot be null"); }
	
		businessCase.setCreateddate(new Date());
		BusinessCase dbusinessCase = businessCaseService.create(businessCase);

	
		try {
			notificationService.sendNotification(dbusinessCase);
		}catch (MailException e) {
			
		logger.info("error message"+e.getMessage());	
		}
		
		
		
		return new ResponseEntity<BusinessCase>(dbusinessCase  ,HttpStatus.OK) ;
	}
	

//afficher toute les Business Cases
	@GetMapping("/businesscase")
	public ResponseEntity<List<BusinessCase>> listBusinessCase(){
		
		List<BusinessCase> businessCases = businessCaseService.findAll();
		
		return new ResponseEntity<List<BusinessCase>> (businessCases ,HttpStatus.OK);
	
	}
	
//afficher un buisness case
	
	@GetMapping("/businesscase/{id}")
	public ResponseEntity<BusinessCase> findVlan(@PathVariable(value="id")int id){
	

		BusinessCase dbusinessCase = businessCaseService.findone(id);
		
		return new ResponseEntity <BusinessCase> (dbusinessCase ,HttpStatus.OK);
	}
	
	//mise à jour buisnesscase

	
	@PostMapping("/updatebuisnesscase")
	public ResponseEntity<BusinessCase> update(@Valid @RequestBody BusinessCase businessCase ) {
	
		
		
		businessCase.setUpdateddate(new Date());
		BusinessCase dbusinessCase = businessCaseService.update(businessCase);

		try {
			notificationService.sendNotificationUpdate(dbusinessCase);
		}catch (MailException e) {
			
		logger.info("error message"+e.getMessage());	
		}
		
		
		return new ResponseEntity <BusinessCase> (dbusinessCase ,HttpStatus.OK);
		
	
}
//suprimer un Business Case	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(value="id")int id  ) {
		
		
		BusinessCase dbusinessCase = repository.findByCasenumber(id);
		

		try {
			notificationService.sendNotificationDelete(dbusinessCase);
		}catch (MailException e) {
			
		logger.info("error message"+e.getMessage());	
		}
		
		
		
		
		businessCaseService.delete(id);
		
	 
	
	}
	
	//supression de tout les business Cases
	

	@DeleteMapping("/deleteall")
	public void deleteAll() {
		
		
		businessCaseService.deleteAll();
	 
	
	}
	
}

