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

//            Person person =session.get(Person.class,3);
//            System.out.println(person);
//            List<Item> items=person.getItems();
//            System.out.println(items);

//            Item item =session.get(Item.class,5);
//            System.out.println(item);
//            System.out.println(item.getOwner());

//            Person person= session.get(Person.class,2);
//            Item newItem = new Item("Item1",person);
//            person.getItems().add(newItem);
//            session.save(newItem);

            //if we dont save person we ll get err bcase of lack of cascading
//            Person person =new Person("SomeName",20);
//            Item item = new Item("Item2",person);
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//            session.save(person);
//            session.save(item);

            //deleting item that own person
//            Person person = session.get(Person.class,3);
//            List<Item> items = person.getItems();
//            for (Item item:items){
//                session.remove(item);
//            }
//            person.getItems().clear();
//deleting person
//            Person person = session.get(Person.class,2);
//            session.remove(person);
//            person.getItems().forEach(i->i.setOwner(null));


//            Person person = session.get(Person.class,4);
//            Item item = session.get(Item.class,1);
//            item.getOwner().getItems().remove(item);
//            item.setOwner(person);
//            person.getItems().add(item);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
