/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.shp.controller.DAO.impl;

import com.leapfrog.shp.DAO.EmployeeDAO;
import com.leapfrog.shp.entity.Employee;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Narayan
 */
@Repository(value = "employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    Transaction transaction;

    @Override
    public void insert(Employee t) {
        
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
        
    }

    @Override
    public void update(Employee t) {

        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        t.setModifiedDate(Calendar.getInstance().getTime());
        session.update(t);
        transaction.commit();
        session.close();
        
        
        
        
    }

    @Override
    public Employee getById(int id) {
        
        session=sessionFactory.openSession();
        Employee employee=(Employee)session.get(Employee.class, id);        
        session.close();
        
        return employee;
    }

    @Override
    public List<Employee> getAll() {

    session=sessionFactory.openSession();
        Query query=session.getNamedQuery("Employee.findAll");
        List<Employee> employeeList=query.list();
        session.close();
        return employeeList;
    
    }

    @Override
    public void delete(int id) {

        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        Employee e= (Employee) session.get(Employee.class, id);
        session.delete(e);
        transaction.commit();
        session.close();
        
    
    
    }

  
}
