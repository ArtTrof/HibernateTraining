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
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//creating movie and its actors
//            Movie movie = new Movie("Criminal",1994);
//            Actor actor1= new Actor("Bimba",29);
//            Actor actor2= new Actor("Boba",39);
//            movie.setActors(new ArrayList<>(List.of(actor1,actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);
//get actors from movie with id=
//           Movie movie =session.get(Movie.class,5);
//           System.out.println(movie.getActors());
//add new movie to existing actor
//            Movie movie = new Movie("Dawg", 1999);
//            Actor actor = session.get(Actor.class, 9);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);
//delete movie from actor
//            Actor actor = session.get(Actor.class,9);
//            System.out.println(actor.getMovies());
//            Movie removeMovie = actor.getMovies().get(0);
//            actor.getMovies().remove(0);
//            removeMovie.getActors().remove(actor);

            session.getTransaction().commit();
        }


    }
}
