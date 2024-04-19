package com.example.HumanResource.Controller;

import com.example.HumanResource.Entity.Departments;
import com.example.HumanResource.Model.DepartmentDTO;
import com.example.HumanResource.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @GetMapping("/department")
    public String DepartmentPage(Model model){
        List<DepartmentDTO> departments =service.getAll();
        model.addAttribute("departmentList", departments);
        return "department.html";
    }

    @GetMapping("/department/new")
    public String GDepartmentNew(){
        return "department_new.html";
    }

    @GetMapping("/department/delete")
    public String GDeleteDepartment(@RequestParam("id") String departmentID){
        service.DeleteDepartment(departmentID);
        return "redirect:/department";
    }
    @GetMapping("/department/edit")
    public String GDepartmentEdit(@RequestParam("id") String departmentID, Model model){
        DepartmentDTO departmentDTO = service.findById(departmentID);
        model.addAttribute("currentDepartment", departmentDTO);
        return "department_edit.html";
    }
    @PostMapping("/department/edit")
    public String PDepartmentEdit(@ModelAttribute DepartmentDTO departmentDTO){
        service.EditDepartment(departmentDTO);
        return "redirect:/department";
    }
    @PostMapping("/department/new")
    public String PDepartmentNew(@ModelAttribute Departments departments){
        service.AddDepartment(departments);
        return "redirect:/department";
    }
}
