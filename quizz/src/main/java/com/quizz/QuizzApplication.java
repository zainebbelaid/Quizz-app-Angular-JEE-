package com.quizz;

//import com.quizz.dao.ThemeDao;
//import com.quizz.model.Theme;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Controller;

//@ComponentScan(basePackages = { "org.kemri.wellcome.hie" }, 
//excludeFilters = {@Filter(value = Controller.class, type = FilterType.ANNOTATION)})

//@PropertySource("classpath:application.properties")

@SpringBootApplication
@EnableEurekaServer
public class QuizzApplication {

    @Autowired
   //private ThemeDao themeDao;

    public static void main(String[] args) {
        SpringApplication.run(QuizzApplication.class, args);
        System.out.println("l'Application est démarrée");
    }
	
	/*
	 * @Bean CommandLineRunner runner() { return args -> { themeDao.save(new
	 * Theme("Java")); }; }
	 */
	  
}
