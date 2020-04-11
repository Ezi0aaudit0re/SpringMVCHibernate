package com.springmvc.hibernate.demo.CRUDAssignment;

import com.springmvc.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Driver {


    public void create(SessionFactory factory){
        System.out.println("Creating users");


        Session session = factory.getCurrentSession();

        session.beginTransaction();

        new Create().create(session);

        session.getTransaction().commit();

        System.out.println("Users Created");

    }


    public void read(SessionFactory factory){

        System.out.println("Reading from database");

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Read read = new Read();

        List<Employee> employeeList = read.query(session, "Delete");

        if(employeeList.size() == 1){
            System.out.println(employeeList.get(0));
        }


        Employee employee = read.query(session, 1);

        System.out.println("Employee with ID 1");

        System.out.println(employee);


        session.getTransaction().commit();

    }


    public void update(SessionFactory factory){

        System.out.println("Updating");
        Session  session = factory.getCurrentSession();

        session.beginTransaction();


        Updage update = new Updage();



        System.out.println("Changing amazon to evil");

        update.changeToEvil(session, "Amazon");



        System.out.println("Changing ID 1 to evil");
        update.changeToEvil(session, 1);

        session.getTransaction().commit();

    }


    public void delete(SessionFactory factory){

        System.out.println("Deleting");


        Delete delete = new Delete();

        Session session = factory.getCurrentSession();


        System.out.println("Deleting user Evil");

        session.beginTransaction();

//        delete.delete(session, "Evil");


        System.out.println("Deleting user id 1");

        delete.delete(session, 2);

        session.getTransaction().commit();



    }


    public static void main(String[] args) {

        Driver driver = new Driver();

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        driver.delete(factory);

    }





}
