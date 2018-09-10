package org.isi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class BusinessCase {
	@Id @GeneratedValue
	private int casenumber ;
	
	private String object ;
	private Date createddate;
	private Date updateddate;
	private String summary;
	
	@Enumerated(EnumType.STRING)
	private StatusType status =StatusType.OPENED ;
	public BusinessCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessCase(int casenumber, String object, Date createddate, Date updateddate, String summary,
			StatusType status) {
		super();
		this.casenumber = casenumber;
		this.object = object;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.summary = summary;
		this.status = status;
	}
	public int getCasenumber() {
		return casenumber;
	}
	public void setCasenumber(int casenumber) {
		this.casenumber = casenumber;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	

}
