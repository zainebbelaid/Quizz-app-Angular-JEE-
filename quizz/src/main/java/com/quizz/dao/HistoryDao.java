package com.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.model.History;

@Repository

//étendre la classe JpaRepository qui contient une API pour
//les operrations CRUD de base

//Il faut passer deux paramètres:
//le type de l'entité qu'il gère et le type du champ Id.
public interface HistoryDao extends JpaRepository<History, Long> {
	
  History findHistoryByScore(int score);

  History findHistoryByUsername(String username);
}
