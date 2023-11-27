package com.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.model.Theme;

//Il faut passer deux paramètres:
//le type de l'entité qu'il gère et le type du champ Id.
//étendre la classe JpaRepository ui contientune API pour
//les operrations CRUD de base
@Repository
public interface ThemeDao extends JpaRepository<Theme, Long> {

	

}
