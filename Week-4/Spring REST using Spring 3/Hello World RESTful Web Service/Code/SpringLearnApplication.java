package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class); 

    public static void main(String[] args) {
    	SpringApplication.run(SpringLearnApplication.class, args);
        //displayDate();
        //displayCountry();
        //displayCountries();
    }

    public static void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Date: {}", date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOGGER.info("END");
    }
    
    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country c1 = context.getBean("in", Country.class);
        //Country c2 = context.getBean("country", Country.class);
        LOGGER.debug("Country: {}", c1.toString());
    }
    public static void displayCountries() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);
        LOGGER.debug("Countries: {}", countries);
    }
	
}
