package org.isi.service;

import java.util.List;

import org.isi.dao.VlanRepository;
import org.isi.entities.Vlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

public interface VlanService {

    Vlan create(Vlan vlan);
    List<Vlan> findAll();
    void  delete(int id);
    void update(int id ,Vlan vlan);
    void deleteAll();
  /*  public boolean isVlanExist(Vlan vlan);
    Vlan findByName(String name);*/
  /* Vlan findById(long id)*/
   /* Vlan findOne(int id);
*/
 /* Vlan delete(int id);
 */
  /* 
   

   ;

Vlan update(Vlan user)*/

}
