package com.quizz.impl;

//import com.quizz.dao.LevelDao;
import com.quizz.dao.QuestionDao;
import com.quizz.model.Level;
import com.quizz.model.Question;
import com.quizz.servce.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//un modèle de conception de logiciel couramment utilisé pour 
//développer l'interface utilisateur qui divise la logique du programme
//associé en trois éléments interconnectés
@Transactional
@Component

public class QuestionServiceImpl implements QuestionService {

	@Autowired
    private QuestionDao questionDao;

	
	/*
	 * @Autowired private LevelDao levelDao;
	 */	 

	/*
	 * @Autowired public QuestionServiceImpl(QuestionDao questionDao, LevelDao
	 * levelDao) { this.questionDao = questionDao; this.levelDao = levelDao; }
	 */

    @Override
    public Question addQuestion(Question question, Level level) {
        level.addQuestion(question);
        return questionDao.save(question);
    }
}
