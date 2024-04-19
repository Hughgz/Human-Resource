package com.example.HumanResource.Service;

import com.example.HumanResource.Entity.Departments;
import com.example.HumanResource.Model.DepartmentDTO;

import java.util.List;

public interface IDepartmentService {
    void AddDepartment(Departments departments);
    void EditDepartment(DepartmentDTO departmentDTO);
    void DeleteDepartment(String id);
    List<DepartmentDTO> getAll();
    DepartmentDTO findById(String id);
    DepartmentDTO convert(Departments departments);
}
