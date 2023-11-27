package com.quizz.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.quizz.model.Question;
import org.springframework.stereotype.Repository;

//Il faut passer deux paramètres:
//le type de l'entité qu'il gère et le type du champ Id.
//étendre la classe JpaRepository ui contientune API pour
//les operrations CRUD de base

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
}