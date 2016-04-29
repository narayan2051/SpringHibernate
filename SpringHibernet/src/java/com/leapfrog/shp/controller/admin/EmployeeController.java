/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.shp.controller.admin;

import com.leapfrog.shp.DAO.DepartmentDAO;
import com.leapfrog.shp.DAO.EmployeeDAO;
import com.leapfrog.shp.entity.Department;
import com.leapfrog.shp.entity.Employee;
import java.util.Calendar;
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
@RequestMapping(value = "admin/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("employees", employeeDAO.getAll());

        return "admin/employee/index";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)

    public String save(@RequestParam("id") Integer id, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
            @RequestParam("email") String email, @RequestParam("contact") String contact, @RequestParam("status") Boolean status, @RequestParam("department_id") int dept_id) {

        
        //Employee e = new Employee(0, firstName, lastName, email, contact, status);
        Employee e=employeeDAO.getById(id);
        e.setId(id);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setContactNo(contact);
        e.setEmail(email);
        e.setStatus(status);
        e.setDeptId(new Department(dept_id));

        if (e.getId() == null) {

            employeeDAO.insert(e);
        } else {
            e.setId(id);
           
            employeeDAO.update(e);

        }
        return "redirect:/admin/employee";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)

    public String add(Model model) {
        model.addAttribute("depts", departmentDAO.getAll());

        return "admin/employee/add";

    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {

        model.addAttribute("employee", employeeDAO.getById(id));
        model.addAttribute("depts", departmentDAO.getAll());

        return "admin/employee/edit";

    }
@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {

       employeeDAO.delete(id);

     return   "redirect:/admin/employee";

    }

    @RequestMapping(value = "status/{id}",method = RequestMethod.GET)
public String status(@PathVariable("id") int id){
    
    Employee e= employeeDAO.getById(id);
    if(e.getStatus()){
        e.setStatus(false);
    }else{
        e.setStatus(true);
    }
    
    employeeDAO.update(e);
    return   "redirect:/admin/employee";
    
}    
    
    
    
    
    
    
}
