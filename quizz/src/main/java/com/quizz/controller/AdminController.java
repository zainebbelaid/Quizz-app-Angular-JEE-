package com.quizz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizz.model.Admin;
import com.quizz.servce.AdminService;


@RestController
public class AdminController {
	
	@Autowired
    private AdminService service;
	
    @PostMapping("/authadmin")
    @CrossOrigin(origins = "http://localhost:4200")
   
	public Admin authentificationAdmin(@RequestBody Admin admin) throws Exception{
   	 String tempadminname = admin.getAdminname();
   	 
   	 if(tempadminname != null &&  !"".equals(tempadminname)) {
   		 
   		Admin adminobj =  service.fetchUserByadminname(tempadminname);
   		if(adminobj != null) {
   			throw new Exception("admin whith"+tempadminname+"is already exist");
   		}
   	 }
   	 
		Admin adminObj = null;
		adminObj = service.saveAdmin(admin);
		return adminObj;
		
	}
    
    @PostMapping("/loginadmin")
    @CrossOrigin(origins = "http://localhost:4200")
    
    public Admin loginAdmin(@RequestBody Admin admin )throws Exception {
   	 String tempadminname = admin.getAdminname();
   	 String tempPassword = admin.getPassword();
   	 Admin adminobj = null;
   	 if(tempadminname != null && tempPassword != null) {
   		 adminobj = service.fetchUserByadminnameAndPassword(tempadminname, tempPassword);
   	 }
   	 if(adminobj == null) {
   		 throw new Exception("bad credentials");
   	 }
   	 return adminobj;
   	 
    }

}
