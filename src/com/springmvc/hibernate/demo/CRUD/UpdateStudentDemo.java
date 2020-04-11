package com.springmvc.hibernate.demo.CRUD;

import com.springmvc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class UpdateStudentDemo {


    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();


        try{



            // get students ID
            System.out.println("Getting Student ID");

            session = factory.getCurrentSession();
            session.beginTransaction();


            session.createQuery("update Student set firstName = 'Aman' where firstName='Updated'").executeUpdate();

//
//            Student theStudent = (Student) session.createQuery("from Student s where s.firstName = 'Aman'").getResultList().get(0);
//
//            theStudent.setFirstName("Updated");
//            System.out.println(theStudent);


            session.getTransaction().commit();

            System.out.println("Updated");



        }
        finally{
            factory.close();
        }


    }
}
