package com.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizz.model.Admin;


public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	public Admin findByadminname(String adminname);
	public Admin findByadminnameAndPassword(String adminname,String password);

}
