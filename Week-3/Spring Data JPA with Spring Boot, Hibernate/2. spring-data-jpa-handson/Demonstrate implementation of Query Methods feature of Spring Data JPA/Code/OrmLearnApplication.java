package com.cognizant.orm_learn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryAlreadyExistsException;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args)  {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
        countryService = context.getBean(CountryService.class);
        //testGetAllCountries();
        //testAddCountry();
        //getAllCountriesTest();
        testFindByNameContaining();
        testFindByNameContainingSorted();
        testFindByNameStartingWith();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }
    
    private static void getAllCountriesTest() {
        LOGGER.info("Start");
        String code = "RR"; 

        try {
            Country country = countryService.findCountryByCode(code);
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
        	LOGGER.error("{}", e.getMessage());
        }

        LOGGER.info("End");
    } 
    private static void testAddCountry() {
        LOGGER.info("Start");
        Country newCountry = new Country();
        newCountry.setCode("IN");
        newCountry.setName("India");

        try {
            countryService.addCountry(newCountry);
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Added Country: {}", country);
        } catch (CountryAlreadyExistsException e) {
            LOGGER.error("Add failed: {}", e.getMessage());
        } catch (CountryNotFoundException e) {
            LOGGER.error("Verification failed: {}", e.getMessage());
        }

    }
    private static void testFindByNameContaining() {
        LOGGER.info("Start - testFindByNameContaining");
        List<Country> countries = countryService.findByNameContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End");
    }
    private static void testFindByNameContainingSorted() {
        LOGGER.info("Start - testFindByNameContainingSorted");
        List<Country> countries = countryService.findByNameContainingSorted("ou");
        LOGGER.debug("Countries containing 'ou' sorted: {}", countries);
        LOGGER.info("End");
    }
    private static void testFindByNameStartingWith() {
        LOGGER.info("Start - testFindByNameStartingWith");
        List<Country> countries = countryService.findByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End");
    }

}
