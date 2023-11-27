package com.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizz.model.User;


public interface UserDao  extends JpaRepository<User, Integer> {

	public User findByEmailid(String emailid);
	public User findByEmailidAndPassword(String emailid,String password);
}
