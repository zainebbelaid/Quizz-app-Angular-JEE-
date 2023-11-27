package com.quizz.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String difficulty;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}




	//traitement pour ajouter des question
	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
	private List<Question> questions;
	
	

	public void addQuestion(Question question) {
		if (getQuestions()==null) {
			this.questions = new ArrayList<>();
		}
		getQuestions().add(question);
		question.setLevel(this);
	}
          /*________________________________*/
	
	@ManyToOne
	private Theme theme;

}
