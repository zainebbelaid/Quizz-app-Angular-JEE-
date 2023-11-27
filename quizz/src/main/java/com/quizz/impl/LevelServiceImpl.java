package com.quizz.impl;

import com.quizz.servce.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.quizz.dao.LevelDao;
import com.quizz.model.Level;
import com.quizz.model.Theme;
//import com.quizz.dao.ThemeDao;

@Transactional
@Component

public class LevelServiceImpl implements LevelService {

	
	@Autowired
	private LevelDao levelDao;

	//@Autowired
	//private ThemeDao themeDao;
	
  
	@Override
	public Level addLevel(Level level, Theme theme) {
		// package modele la classe theme contient la la fonction addlevel
	    
		theme.addLevel(level);
		return levelDao.save(level);
	}

}
