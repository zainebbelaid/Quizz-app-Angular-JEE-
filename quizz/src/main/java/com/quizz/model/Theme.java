package com.quizz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;

import lombok.RequiredArgsConstructor;
//import lombok.Setter;
import lombok.ToString;



@Data
//@Getter
//@Setter
@RequiredArgsConstructor(staticName  =  "of") 
@AllArgsConstructor(access  = AccessLevel.PROTECTED)
@ToString
@Entity
public class Theme {
	
	@Id
	//indique que le clé primaire est générée une facon automatique lors de l'insertion de la base
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;}

	
	

	//traitement pour ajouter des niveaux
	
	

	@OneToMany
	(mappedBy = "theme", cascade = CascadeType.ALL)
	private List<Level> levels;

	public void addLevel(Level level) {
		//si le theme n'a jamais  crée un niveau le systéme va créer arraylist pour les nivaeux
		if(getLevels()==null) {
			this.levels = new ArrayList<>();
		}
		//si non va créer un nauveau niveau
		getLevels().add(level);
		level.setTheme(this);
	}


    /*________________________________*/

	

}
