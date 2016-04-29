/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.shp.DAO;

import java.util.List;

/**
 *
 * @author Narayan
 */
public interface GenericDAO<T> {
    
    void insert (T t);
    void update(T t);
    T getById(int id);
    List<T> getAll();
    void delete(int id);
    
    
    
    
}
