package com.springmvc.hibernate.demo.CRUDAssignment;

import com.springmvc.hibernate.demo.entity.Employee;
import org.hibernate.Session;

public class Updage {

    /**
     * Update name company name to evil
     */
    public void changeToEvil(Session session, String company){

        session.createQuery("update Employee set company='EVIL' where company=:cmpny").setParameter("cmpny", company).executeUpdate();


    }

    public void changeToEvil(Session session, int id){

        Employee employee = new Read().query(session, id);

        employee.setCompany("EVIL");


    }



}
