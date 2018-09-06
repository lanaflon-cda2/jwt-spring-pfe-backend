package org.isi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 

public class Vlan {
@Id @GeneratedValue
private int id ;
private String name ;
private String vlan_type  ;
private int qos ;
private Date createddate;
private Date updateddate;
public Vlan(int id, String name, String vlan_type, int qos, Date createddate, Date updateddate) {
	super();
	this.id = id;
	this.name = name;
	this.vlan_type = vlan_type;
	this.qos = qos;
	this.createddate = createddate;
	this.updateddate = updateddate;
}
public Vlan() {
	super();
	// TODO Auto-generated constructor stub
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
public int getQos() {
	return qos;
}
public void setQos(int qos) {
	this.qos = qos;
}
public Date getCreateddate() {
	return createddate;
}
public void setCreateddate(Date createddate) {
	this.createddate = createddate;
}
public Date getUpdateddate() {
	return updateddate;
}
public void setUpdateddate(Date updateddate) {
	this.updateddate = updateddate;
}




}
