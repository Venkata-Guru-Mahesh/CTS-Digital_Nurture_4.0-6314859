package com.cognizant.orm_learn;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.orm_learn.hibernate.HibernateExample;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class OrmApplication {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(OrmApplication.class);

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
        LOGGER.info("Inside main");

        HibernateExample example = new HibernateExample();
        Employee emp1 = new Employee();
        emp1.setName("Alice");
        emp1.setDepartment("Finance");
        Integer id1 = example.addEmployee(emp1);
        LOGGER.info("Hibernate inserted employee with ID: " + id1);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            Employee emp2 = new Employee();
            emp2.setName("Bob");
            emp2.setDepartment("IT");
            employeeService.addEmployee(emp2);
            LOGGER.info("Spring Data JPA inserted employee: " + emp2);
        };
    }
}
