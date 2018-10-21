package org.isi.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;


import org.isi.entities.Vlan;
import org.isi.service.VlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController 

public class VlanRestController {
	@Autowired 
	VlanService vlanservice;//service avec lequelle les data vlan vont etre manipuler 
	
	//affichage de tout les vlan
	@GetMapping("/vlan")
	public ResponseEntity<List<Vlan>> listVlans(){
		
		
	List<Vlan>  vlans = vlanservice.findAll();
	return new ResponseEntity<List<Vlan>> (vlans,HttpStatus.OK);
	
		
	}
	//creation de vlan
	@PostMapping("/vlan")
	public ResponseEntity<Vlan>  save(@RequestBody Vlan vlan) {
		
		if (vlan==null)
		{throw new NullPointerException("vlan object cannot be null"); }	
		vlan.setCreateddate(new Date());
		 Vlan dbvlan = vlanservice.create(vlan);
		 return new ResponseEntity<Vlan>(dbvlan ,HttpStatus.OK) ;
		 
		
	}
	//afficher une vlan 
	@GetMapping("/vlan/{id}")
	public ResponseEntity<Vlan> findVlan(@PathVariable(value="id")int id){
		
		
		
		 Vlan dbvlan =vlanservice.findone(id);
		 return new ResponseEntity<Vlan>(dbvlan ,HttpStatus.OK) ;
		
	}
	
	

	

	@PostMapping("/updatevlan")
	public ResponseEntity<Vlan> update(@Valid @RequestBody Vlan vlan ) {
		String name=null;
		String vlan_type=null;
		//return  taskRepository.save(t);
		vlan.setUpdateddate(new Date());
		
		Vlan dbvlan =  vlanservice.update(vlan);
	
		 return new ResponseEntity<Vlan>(dbvlan ,HttpStatus.OK) ;
	}
	
	//supression Vlan 
	 

	@DeleteMapping("/vlan/{id}")
	public void delete(@PathVariable(value="id")int id  ) {
		
		
	 vlanservice.delete(id);
	
	}

	@DeleteMapping("/vlan")
	public void deleteAll() {
		//return  taskRepository.save(t);
	 vlanservice.deleteAll();
	
	}
}
