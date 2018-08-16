package org.isi.service;

import java.util.List;

import org.isi.dao.VlanRepository;
import org.isi.entities.Vlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface VlanService {

    Vlan create(Vlan vlan);
    List<Vlan> findAll();
    Vlan delete(int id);
    Vlan update(Vlan vlan);
  /* Vlan findById(long id)*/
   /* Vlan findOne(int id);
*/
 /* Vlan delete(int id);
 */
  /* 
   

   ;

Vlan update(Vlan user)*/

}
