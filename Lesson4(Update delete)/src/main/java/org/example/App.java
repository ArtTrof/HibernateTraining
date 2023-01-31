package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
//update person
//            Person person = session.get(Person.class,2);
//            person.setName("New name");
//delete person
//            Person person = session.get(Person.class,2);
//            session.delete(person);
//hibernate remembers id of created person
            Person person = new Person("some name",20);
            session.save(person);
            System.out.println(person.getId());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
