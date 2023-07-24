package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ToDo {
	@Id
	private int tdId;
	private String tdMsg;
	private boolean tdDone;
	
	public ToDo() {
		super();
	}

	public ToDo(int tdId, String tdMsg) {
		super();
		this.tdId = tdId;
		this.tdMsg = tdMsg;
		this.tdDone = false;
	}

	public ToDo(int tdId, String tdMsg, boolean tdDone) {
		super();
		this.tdId = tdId;
		this.tdMsg = tdMsg;
		this.tdDone = tdDone;
	}
	
	public int getTdId() {
		return tdId;
	}
	public void setTdId(int tdId) {
		this.tdId = tdId;
	}
	public String getTdMsg() {
		return tdMsg;
	}
	public void setTdMsg(String tdMsg) {
		this.tdMsg = tdMsg;
	}
	public boolean isTdDone() {
		return tdDone;
	}
	public void setTdDone(boolean tdDone) {
		this.tdDone = tdDone;
	}
	
	@Override
	public String toString() {
		return "ToDo [tdId=" + tdId + ", tdMsg=" + tdMsg + ", tdDone=" + tdDone + "]";
	}
}
