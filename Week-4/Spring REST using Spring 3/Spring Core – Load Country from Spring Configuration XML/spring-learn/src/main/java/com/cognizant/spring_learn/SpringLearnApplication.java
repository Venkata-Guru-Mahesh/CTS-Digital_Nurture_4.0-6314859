package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}
	
	public static void displayDate() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            System.out.println("Parsed Date: " + date);
            System.out.println("Formatted Date: " + format.format(date));
            
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
    }
	
}
