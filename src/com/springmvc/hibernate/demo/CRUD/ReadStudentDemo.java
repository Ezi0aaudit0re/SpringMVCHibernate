package com.springmvc.hibernate.demo.CRUD;

import com.springmvc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ReadStudentDemo {


    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();


        try{

//            // create student object
//            System.out.println("Creating Java object");
//            Student tempStudent = new Student("Daffy", "Duck", "daffy@bu.edu");
//
//
//
//            // start a stransaction
//            session.beginTransaction();
//
//            session.save(tempStudent);
//
//
//            // commit
//            session.getTransaction().commit();
//
//
//            System.out.println("Transaction completed");



            // get students ID
            System.out.println("Getting Student ID");

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("End bu.edu");
            List<Student> theStudent = session
                    .createQuery("from Student s where s.email LIKE '%bu.edu'")
                    .getResultList();


            System.out.println(theStudent);

            System.out.println("First Name: Daffy");

            theStudent = session.createQuery("from Student s where s.firstName = 'Aman'").getResultList();

            System.out.println(theStudent);


            session.getTransaction().commit();



        }
        finally{
            factory.close();
        }


    }
}
