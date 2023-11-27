package com.quizz.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor(staticName = "of")
@ToString
@Entity
//fournir une operation depuis et vers la basede donnée
public class User {
	
	@Id
	//générée dune facon automatique le clé primaire lors de l'instalation 
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String emailid;
	private String username;
	private String password;
	
	
	public User() {
		
	}
	
	public User(int id, String emailid, String username, String password) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}