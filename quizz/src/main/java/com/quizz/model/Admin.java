package com.quizz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id

	private int id;
	
	private String adminname;
	private String password;
	
	public Admin(int id, String adminname, String password) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.password = password;
	}
	
	public Admin() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

