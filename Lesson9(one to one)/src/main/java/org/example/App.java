package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class).addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

//                Person person=new Person("test",30);
//                Passport passport = new Passport(2001);
//                person.setPassport(passport);
//                session.save(person);

//                Person person =session.get(Person.class,1);
//            System.out.println(person.getPassport().getPassportNumber());
//
//            Passport passport = session.get(Passport.class,1);
//            System.out.println(passport.getPerson().getName());
//
//            Person person1 = session.get(Person.class,1);
//            person1.getPassport().setPassportNumber(7777);
//
//            Person person2 = session.get(Person.class,2);
//            session.remove(person2);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
