package com.mariia.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class.getName());
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            executeOperations(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            StandardServiceRegistryBuilder.destroy( registry );

        }


    }

    private static void executeOperations(Session session) {
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
                    log.info("Create user menu");
                    createUser(console, session);
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

    private static void createUser(Scanner console, Session session) {
        System.out.println("Enter the name");
        var name = console.next();
        Employee foundEmployee = getEmployee(session, name);
        log.info("Employee {}", foundEmployee);
        if (foundEmployee == null) {
            createUserInDb(name, session);
        } else {
            System.out.println("Wrong name, try one more time");
            createUser(console, session);
            log.info("User created successfully");
        }
    }

    private static void createUserInDb(String name, Session session) {
        Chief chief = session.get(Chief.class, 1);
        Employee newEmployee = new Employee();
        newEmployee.setChief(chief);
        newEmployee.setName(name);
        session.persist(newEmployee);
    }

    private static Employee getEmployee(Session session, String name) {
        var query = session.createQuery("From Employee E where E.name = :name", Employee.class);
        query.setParameter("name", name);
        var result = query.getResultList();
        if (result.size() == 1) {
            return result.get(0);
        } else if (result.size() > 1)  {
            throw new MoreThanOneUserException("More than one user with name " + name);
        } else  {
            return null;
        }
    }
}
