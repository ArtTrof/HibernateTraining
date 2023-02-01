package org.example;


import org.example.model.Item;
import org.example.model.Person;
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
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();
            //creating person with item (cascading) save method-
//            Person person = new Person("Tom",20);
//            Item newItem = new Item("TestCascading item",person);
//            person.setItems(Collections.singletonList(newItem));
//            session.save(person);

            Person person = new Person("Tom", 20);
            person.addItem(new Item("TestCascading item1"));
            person.addItem(new Item("TestCascading item2"));
            person.addItem(new Item("TestCascading item3"));
            session.save(person);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
