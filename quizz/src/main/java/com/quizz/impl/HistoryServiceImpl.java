
package com.quizz.impl; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 
import org.springframework.transaction.annotation.Transactional; 
import com.quizz.dao.HistoryDao; 
import com.quizz.model.History;
import com.quizz.servce.HistoryService; 

@Transactional 
@Component 
public class HistoryServiceImpl implements  HistoryService { 

 @Autowired 
 private HistoryDao historyDao; 
	
 @Override 
 public History addHistory(History history) { 
	return historyDao.save(history); 
 } 
    
 @Override 
 public History editHistory(History history, History history1) { 
       history.setUsername(history1.getUsername()); 
       history.setLevelName(history1.getLevelName());
       history.setThemeName(history1.getThemeName()); 
       history.setScore(history1.getScore()); 
       history.setTotal(history1.getTotal()); 
       return historyDao.save(history); 
    } 
} 

