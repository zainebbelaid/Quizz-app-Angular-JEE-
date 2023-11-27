package com.quizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizz.dao.UserDao;

import com.quizz.model.User;
import com.quizz.servce.UserService;



@RestController
public class UserController {

	
	
	@Autowired
    private UserDao userDao;
	@Autowired
    private UserService service;
	
	//il permett de maper les requetes http post sur une methode gestionnaires
    @PostMapping("/authuser")
    @CrossOrigin(origins = "http://localhost:4200")
   
	public User authentificationUser(@RequestBody User user) throws Exception{
   	 String tempemailid = user.getEmailid();
   	 
   	 //verifier si user existe
   	 if(tempemailid != null &&  !"".equals(tempemailid)) {
   		 User userobj =  service.fetchUserByEmailid(tempemailid);
   		 
   		if(userobj != null) {
   			throw new Exception("user whith"+tempemailid+"is already exist");
   		                     }
   	  }
   	 
   	 //enrg user 
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
		
	}
    
 
    @PostMapping("/loginuser")
    @CrossOrigin(origins = "http://localhost:4200")
    
  
    
    public User loginUser(@RequestBody User user )throws Exception {
   	 String tempEmailid = user.getEmailid();
   	 String tempPassword = user.getPassword();
   	 
   	 User userobj = null;
   	 if(tempEmailid != null && tempPassword != null) {
   		 userobj = service.fetchUserByEmailidAndPassword(tempEmailid, tempPassword);
   	 }
   	 if(userobj == null) {
   		 throw new Exception("bad credentials");
   	 }
   	 return userobj;
   	 
    }
    
    @GetMapping("/getUsers")
    public List<User> getUsers() {
    	  List<User> users = userDao.findAll();
    	  return users;
    }
    
    
    @GetMapping("/getUsers/{idUser}")
    public User getUser(@PathVariable Integer idUser) {
    	
    	return userDao.findById(idUser).get();
    }
    


}