package org.isi.service;

import java.util.List;

import org.isi.entities.BusinessCase;
import org.isi.entities.Vlan;

public interface BusinessCaseService {
	
	BusinessCase create(BusinessCase businessCase);
	    List<BusinessCase > findAll();
	    void  delete(int id);
	    BusinessCase  update(BusinessCase  businessCase );
	    void deleteAll();
	    BusinessCase  findone(int id);

}
