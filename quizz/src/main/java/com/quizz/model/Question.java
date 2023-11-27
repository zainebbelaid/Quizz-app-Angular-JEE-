package com.quizz.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



//import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
import lombok.RequiredArgsConstructor;
//import lombok.Setter;
import lombok.ToString;

@Data
 
@RequiredArgsConstructor(staticName  =  "of") 
@AllArgsConstructor(access  = AccessLevel.PROTECTED) 
@ToString
@Entity
public class Question {
@Id 
@GeneratedValue(strategy  = GenerationType.IDENTITY) 

private Long id;
private String question;
private String response1;
private String response2;
private String response3;
private String correct;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getResponse1() {
	return response1;
}

public void setResponse1(String response1) {
	this.response1 = response1;
}

public String getResponse2() {
	return response2;
}

public void setResponse2(String response2) {
	this.response2 = response2;
}

public String getResponse3() {
	return response3;
}

public void setResponse3(String response3) {
	this.response3 = response3;
}

public String getCorrect() {
	return correct;
}

public void setCorrect(String correct) {
	this.correct = correct;
}

public Level getLevel() {
	return level;
}

public void setLevel(Level level) {
	this.level = level;
}




@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name="level_id", referencedColumnName = "id")
private Level level;

}
