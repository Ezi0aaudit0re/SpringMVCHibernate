package com.springmvc.hibernate.demo.CRUDAssignment;

import com.springmvc.hibernate.demo.entity.Employee;
import org.hibernate.Session;

import java.util.List;

public class Read {



    public Employee query(Session session, int id){

        return session.get(Employee.class, id);

    }


    public List<Employee> query(Session session, String firstname){

        return  session.createQuery("from Employee s where s.firstName=:fName", Employee.class).setParameter("fName", firstname).getResultList();


    }






}
