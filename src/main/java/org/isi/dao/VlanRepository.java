package org.isi.dao;

import java.util.List;

import org.isi.entities.Vlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface VlanRepository extends CrudRepository<Vlan,Integer>{
	 void delete(Vlan vlan);

	    List<Vlan> findAll();
	    Vlan findById(int id );
/*  Vlan findOne(Integer id);*/
	   /* Vlan findById(int id );*/

	Vlan save(Vlan vlan );

	

}
