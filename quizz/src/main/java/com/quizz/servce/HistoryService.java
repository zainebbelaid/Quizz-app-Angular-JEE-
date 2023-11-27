package com.quizz.servce;

import com.quizz.model.History;
import org.springframework.stereotype.Service;

@Service

public interface HistoryService {
	
	//interf historyServiceImpl
    History addHistory(History history);
    
    //interf historyServiceImpl
    History editHistory(History history, History history1);
}
