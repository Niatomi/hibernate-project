package ru.niatomi.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static final SessionFactory FACTORY = configFactory();

    public static SessionFactory configFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static Session createSession() {
        return FACTORY.openSession();
    }
}
