package com.mariia.domain;

import net.minidev.json.JSONUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;


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

           /* Query query = session.createQuery("from Worktime where the_date='2022-08-01'");
            List<Worktime> list = query.list();
            System.out.println(list);
*/
            session.getTransaction().commit();
        }

        Scanner console = new Scanner(System.in);

        System.out.println("Enter command:\n" +
                "c - create new employee\n" +
                "g - get employee entrance date list\n" +
                "a - add entrance date for a specific employee\n" +
                "q - exit");

        if (console.hasNext()) {
            String userInput = console.next();

            switch (userInput) {
                case "c":
                    System.out.println(1);
                    break;
                case "g":
                    System.out.println(2);
                    break;
                case "a":
                    System.out.println(3);
                    break;
                case "q":
                    System.out.println(4);
                    break;
                default:
                    System.out.println("don't correct data");
                    break;
            }

        }
    }
}
