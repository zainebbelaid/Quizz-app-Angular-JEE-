package com.quizz.servce;

import org.springframework.stereotype.Service;

import com.quizz.model.Theme;



@Service
public interface ThemeService {

    Theme addTheme(Theme theme);


}
