package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();
//
//            List<Person>people = session.createQuery("From Person where name like 'P%'").getResultList();
//            for (Person person:people){
//                System.out.println(person.toString());
//            }
//set all name on test where age<30
//             session.createQuery("update Person  set name='TEST' where age<30").executeUpdate();
//delete person where age <30
            session.createQuery("delete Person  where age<30").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
