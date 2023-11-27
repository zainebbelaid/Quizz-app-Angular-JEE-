package com.quizz.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.dao.AdminDao;
import com.quizz.model.Admin;


@Service
public class AdminService {

	@Autowired
	private AdminDao repo;
	
    public Admin saveAdmin(Admin admin) {
	  
	  return repo.save(admin);
	  
  }
    
    public Admin fetchUserByadminname(String adminname) {
  	  return repo.findByadminname(adminname);
  	  
    }
    
    public Admin fetchUserByadminnameAndPassword(String adminname,String password) {
  	  return repo.findByadminnameAndPassword(adminname, password);
  	  
    }
}
