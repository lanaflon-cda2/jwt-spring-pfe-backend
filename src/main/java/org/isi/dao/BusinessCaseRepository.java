package org.isi.dao;

import java.util.List;

import org.isi.entities.BusinessCase;

import org.springframework.data.repository.CrudRepository;

public interface BusinessCaseRepository extends CrudRepository<BusinessCase,Integer> {


	 void delete(BusinessCase businessCase);

	    List<BusinessCase> findAll();
	    BusinessCase findByCasenumber(int id );


	   BusinessCase save(BusinessCase businessCase );

}
