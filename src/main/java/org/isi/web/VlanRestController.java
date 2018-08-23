package org.isi.web;

import java.util.List;

import javax.validation.Valid;

import org.isi.entities.Task;
import org.isi.entities.Vlan;
import org.isi.service.VlanService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Vlan> listVlans(){
		return vlanservice.findAll();
		
	}
	//creation de vlan
	@PostMapping("/vlan")
	public Vlan save(@RequestBody Vlan vlan) {
		//return  taskRepository.save(t);
		return vlanservice.create(vlan);
		
	}
	//mise à jour vlan

	@PutMapping("/vlan/{id}")
	public void update(@PathVariable(value="id")int id , @Valid @RequestBody Vlan vlan ) {
		//return  taskRepository.save(t);
	 vlanservice.update(id, vlan);
	
	}
	
	//supression Vlan 
	

	@DeleteMapping("/vlan/{id}")
	public void delete(@PathVariable(value="id")int id  ) {
		//return  taskRepository.save(t);
	 vlanservice.delete(id);
	
	}

	@DeleteMapping("/vlan")
	public void deleteAll() {
		//return  taskRepository.save(t);
	 vlanservice.deleteAll();
	
	}
}
