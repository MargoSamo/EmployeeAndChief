package com.mariia.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
             session.beginTransaction();

//             Chief load = session.load(Chief.class, 1);
//             Employee get = session.get(Employee.class, 1);
//            System.out.println(get.getName());
//            System.out.println(load.getName());

            Query query = session.createQuery("from Worktime where the_date='2022-08-01'");
            List<Worktime> list = query.list();
            System.out.println(list);


            session.getTransaction().commit();
        }
    }
}
