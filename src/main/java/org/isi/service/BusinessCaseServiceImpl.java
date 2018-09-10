package org.isi.service;

import java.util.List;

import org.isi.dao.BusinessCaseRepository;
import org.isi.entities.BusinessCase;
import org.isi.entities.Vlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessCaseServiceImpl implements BusinessCaseService  {
	@Autowired
	private BusinessCaseRepository  repository ;
	
    @Override
    public BusinessCase create(BusinessCase businessCase) {

    	
    	return repository.save(businessCase);

}
	


    @Override
    public List<BusinessCase> findAll() {
        return repository.findAll();
}

    @Override
    public BusinessCase update(BusinessCase businessCase) {
    	
    	
    	
    	
    	 
    	
    	return repository.save(businessCase);
    	
    
}

    @Override
	public void  deleteAll() {
		
		repository.deleteAll();
		
	
	}
    

    @Override
    public  BusinessCase findone(int id) {
    	BusinessCase businessCase = repository.findByCasenumber(id);
    	
    	return businessCase;
    }
    
    @Override
	public void  delete(int id) {
    	BusinessCase businessCase = repository.findByCasenumber(id);
		repository.delete(businessCase);
		
	
	}

}
