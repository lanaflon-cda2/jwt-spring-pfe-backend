package org.isi.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.isi.dao.VlanRepository;
import org.isi.entities.Vlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional

public class VlanServiceImpl implements VlanService {
	 @Autowired
	    private VlanRepository repository;
	 private static final AtomicLong counter = new AtomicLong();
	 private static List<Vlan> vlans;

	    @Override
	    public Vlan create(Vlan vlan) {
	return repository.save(vlan);
	

	
	

}
	    @Override
	    public List<Vlan> findAll() {
	        return repository.findAll();
	}
		
	    /*@Override
	    public Vlan delete(int id) {
	        Vlan vlan = repository.findById(id);
	        if(vlan != null){
	            repository.delete(vlan);
	        }
	        return vlan;
	}
	 */
	    @Override
	    public Vlan update(Vlan vlan) {
	    	
	    	
	    	
	    	
	    	 
	    	
	    	return repository.save(vlan);
	    	
	    
	}
	    @Override
	    public  Vlan findone(int id) {
	    	Vlan vlan = repository.findById(id);
	    	
	    	return vlan;
	    }
	    
	    
		@Override
		public void  delete(int id) {
			Vlan vlan = repository.findById(id);
			repository.delete(vlan);
			
		
		}
	
		@Override
		public void  deleteAll() {
			
			repository.deleteAll();
			
		
		}
	
	   
	    
	   
	    
}
