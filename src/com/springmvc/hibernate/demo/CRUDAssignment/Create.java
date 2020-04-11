package com.springmvc.hibernate.demo.CRUDAssignment;

import com.springmvc.hibernate.demo.entity.Employee;
import com.springmvc.hibernate.demo.entity.Student;
import org.hibernate.Session;

public class Create {

    public Boolean create(Session session){
        Employee employee1 = new Employee("Aman", "Nagpal", "Google");
        Employee employee2 = new Employee("Vanalika", "Dhakre", "Muton Cadett");
        Employee employee3 = new Employee("Corprate", "Slave1", "Amazon");
        Employee employee4 = new Employee("Capitalizm", "Wipped", "Apple");


        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);


        return true;

    }
}
