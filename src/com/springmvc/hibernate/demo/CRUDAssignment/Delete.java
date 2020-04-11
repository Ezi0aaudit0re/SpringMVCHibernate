package com.springmvc.hibernate.demo.CRUDAssignment;

import com.springmvc.hibernate.demo.entity.Employee;
import org.hibernate.Session;

public class Delete {


    public void delete(Session session, int id){

        Employee employee = new Read().query(session, id);

        session.delete(employee);

        session.getTransaction().commit();


    }



    public void delete(Session session, String company){

        session.createQuery("delete Employee where company=:cmpy").setParameter("cmpy", company).executeUpdate();

        session.getTransaction().commit();


    }
}
