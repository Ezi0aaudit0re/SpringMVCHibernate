package com.springmvc.hibernate.demo.CRUD;

import com.springmvc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {


    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();


        try{



            // get students ID
            System.out.println("Getting Student ID");

            session.beginTransaction();

//            Student duffy = (Student) session.createQuery("from Student s where s.firstName='Daffy'").getResultList().get(0);

            session.createQuery("delete from Student where firstName='Daffy'").executeUpdate();

//            session.delete(duffy);




            session.getTransaction().commit();

            System.out.println("Deleted");



        }
        finally{
            factory.close();
        }


    }
}
