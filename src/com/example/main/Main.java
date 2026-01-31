package com.example.main;

import com.example.main.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] arg) {
        SessionFactory factory = new Configuration().
                configure("hibernate-config.xml").addAnnotatedClass(User.class).
                buildSessionFactory();
        Session session = factory.getCurrentSession();


//        session.beginTransaction();
//        User user = new User("Kareem", "Shahtout", "KAreem123@gmail.com");
//        session.save(user);
//        session.getTransaction().commit();

//        session.beginTransaction();
//
//        User user1 = session.get(User.class, 1);
//        System.out.println(user1);

//        session.beginTransaction();
//
//        User user = session.get(User.class, 1);
//        user.setFirstName("Ahmed");
//        user.setLastName("Mohamed");
//        session.getTransaction().commit();

//        session.beginTransaction();
//        System.out.println(session.get(User.class,1));


        session.beginTransaction();

        session.delete(session.get(User.class, 1));

        session.getTransaction().commit();


    }

}
