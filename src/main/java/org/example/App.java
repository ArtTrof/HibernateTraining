package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
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

//            Person person =session.get(Person.class,1);   //1
//            System.out.println("We got person");
            //now get connected enteties (Lazy load)when fetch=lazy
//            System.out.println(person.getItems());
//            Hibernate.initialize(person.getItems());//method to upload data to cache

//            Item item =session.get(Item.class,1); //2
//            //here eager loading
//            System.out.println("We got item");
//            System.out.println(item.getOwner());

            Person person = session.get(Person.class, 1);

            session.getTransaction().commit();
            System.err.println("Here we out of session");


            //it will work because  info loaded bcase of eager fetch//if fetch lazy we ll get err*if we dont get items separatly)
//            System.out.println(person.getItems());//1
            //we can open new session wherever
            session = sessionFactory.getCurrentSession();//3
            session.beginTransaction();
            System.out.println("we are in second trans");

             person =(Person) session.merge(person);
             Hibernate.initialize(person.getItems());
//               List<Item> allItems= session.createQuery("Select i from Item i where i.owner.id=:person_id", Item.class)
//                        .setParameter("person_id",person.getId()).getResultList();//same as initialize but much more complicated

            session.getTransaction().commit();
            System.out.println("Out of second session");
            System.out.println(person.getItems());
        } finally {
            sessionFactory.close();
        }


    }
}
