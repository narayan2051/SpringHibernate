/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.shp.controller.admin;

import com.leapfrog.shp.DAO.DepartmentDAO;
import com.leapfrog.shp.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Narayan
 */
@Controller
@RequestMapping(value = "/admin/department")
public class DepartmentController {

    @Autowired
    private DepartmentDAO departmentDAO;

    @RequestMapping(method = RequestMethod.GET)

    public String index(Model model) {

        model.addAttribute("depts", departmentDAO.getAll());
        return "admin/department/index";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)

    public String edit(@PathVariable("id") int id, Model model) {

        model.addAttribute("dept", departmentDAO.getById(id));
        return "admin/department/edit";
    }

    
    @RequestMapping(value="add",method = RequestMethod.GET)
     public String add(Model model){
        
         model.addAttribute("dept", new Department());
        return"admin/department/add";   
        
    }
    
    
    
    
    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)

    public String save(@RequestParam("id") Integer id, @RequestParam("name") String name) {

        Department department = new Department(null, name);

        if (id == null) {

            departmentDAO.insert(department);
        } else {
            department.setId(id);
            departmentDAO.update(department);
        }

        return "redirect:/admin/department";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {

                    departmentDAO.delete(id);
                return "redirect:/admin/department";
    }
}
