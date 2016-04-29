/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.shp.controller.DAO.impl;

import com.leapfrog.shp.DAO.DepartmentDAO;
import com.leapfrog.shp.entity.Department;
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
@Repository(value = "departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public void insert(Department t) {

     session=sessionFactory.openSession();
     transaction=session.beginTransaction();
     session.save(t);
     transaction.commit();
     session.close();
    
    }

    @Override
    public void update(Department t) {
      session=sessionFactory.openSession();
     transaction=session.beginTransaction();
     session.saveOrUpdate(t);
     transaction.commit();
     
     session.close();
    }

    @Override
    public Department getById(int id) {

       session=sessionFactory.openSession();
       Department department=(Department)session.get(Department.class,id);//
        session.close();
        return department;
    
    
    }

    @Override
    public List<Department> getAll() {
        
        session=sessionFactory.openSession();
            Query query=session.getNamedQuery("Department.findAll");
            List<Department> departmentList=query.list();//
        session.close();
        return departmentList;
    }

    @Override
    public void delete(int id) {
    session=sessionFactory.openSession();
    transaction=session.beginTransaction();
    Department department=(Department)session.get(Department.class,id);
    if(department!=null){
    session.delete(department);
    transaction.commit();
       }
    
    session.close();

    }

   }
