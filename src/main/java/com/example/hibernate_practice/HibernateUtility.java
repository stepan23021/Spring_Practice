package com.example.hibernate_practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtility {
    private static HibernateUtility ourInstance = new HibernateUtility();

    @org.jetbrains.annotations.Contract(pure = true)
    public static HibernateUtility getInstance() {
        return ourInstance;
    }
    private static SessionFactory factory;
    private HibernateUtility() {
    }
    static synchronized Session getHibernateSession() {

        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return factory.openSession();
    }
    static void closeSessionFactory(){
        factory.close();
    }

}
