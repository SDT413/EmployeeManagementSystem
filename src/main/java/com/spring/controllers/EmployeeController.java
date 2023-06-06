package com.spring.controllers;

import com.spring.entities.Employee;
import com.spring.servecies.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService studentService;
    @GetMapping("/")
    public String getEmployees(Model model) {
        model.addAttribute("employees", studentService.getAllEmployees());
        return "getEmployees-view";
    }
    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee-view";
    }
    @PostMapping("/")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        studentService.saveEmployee(employee);
        return "redirect:/employees/";
    }
    @GetMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = studentService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "addEmployee-view";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        studentService.deleteEmployee(id);
        return "redirect:/employees/";
    }


}
