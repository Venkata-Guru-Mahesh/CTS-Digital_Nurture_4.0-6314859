package com.cognizant.orm_learn.hibernate;

import com.cognizant.orm_learn.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure() // reads hibernate.cfg.xml
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
