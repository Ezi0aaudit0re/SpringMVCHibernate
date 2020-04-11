package com.springmvc.hibernate.demo.CRUD;

import com.springmvc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {


    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();


        try{

            // create student object
            System.out.println("Creating Java object");
            Student tempStudent = new Student("Aman", "Nagpal", "anagpal4@bu.edu");
            Student tempStudent1 = new Student("Vana", "Dhakre", "vana69@gmail.com");
            Student tempStudent2 = new Student("What", "is", "whats@gmail.com");



            // start a stransaction
            session.beginTransaction();



            // save the strudent
            session.save(tempStudent);
            session.save(tempStudent1);
            session.save(tempStudent2);


            // commit
            session.getTransaction().commit();


            System.out.println("Transaction completed");

        }
        finally{
            factory.close();
        }


    }
}
