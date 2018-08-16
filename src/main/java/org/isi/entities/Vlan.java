package org.isi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 

public class Vlan {
	@Id @GeneratedValue
private Integer id ;
private String name ;
private String vlan_type  ;
public Vlan() {
	super();
	// TODO Auto-generated constructor stub
}
public Vlan(int id, String name, String vlan_type) {
	super();
	this.id = id;
	this.name = name;
	this.vlan_type = vlan_type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getVlan_type() {
	return vlan_type;
}
public void setVlan_type(String vlan_type) {
	this.vlan_type = vlan_type;
}




}
