package com.quizz.model;

//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
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
public class History { 

@Id
@GeneratedValue(strategy  = GenerationType.IDENTITY) 
private Long id;
private String username;
private String themeName;
private String levelName;
private int total;
private int score;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getThemeName() {
	return themeName;
}
public void setThemeName(String themeName) {
	this.themeName = themeName;
}
public String getLevelName() {
	return levelName;
}
public void setLevelName(String levelName) {
	this.levelName = levelName;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}


} 
