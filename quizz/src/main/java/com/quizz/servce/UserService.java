package com.quizz.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.dao.UserDao;
import com.quizz.model.User;




//pour indiquer que nous utilisant des api prodect service pour stocker et recuperer mettre a jour et supp..
@Service
public class UserService {

	//afin déviter les setters et les getters
		@Autowired
		private UserDao repo;
		
	    public User saveUser(User user) {
		  
		  return repo.save(user);
		  
	  }
	    
	    public User fetchUserByEmailid(String email) {
	  	  return repo.findByEmailid(email);
	  	  
	    }
	    
	    public User fetchUserByEmailidAndPassword(String email,String password) {
	  	  return repo.findByEmailidAndPassword(email, password);
	  	  
	    }
	}

