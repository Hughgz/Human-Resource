package com.example.HumanResource.Service;

import com.example.HumanResource.Entity.Departments;
import com.example.HumanResource.Model.DepartmentDTO;
import com.example.HumanResource.Repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    DepartmentRepository repository;
    @Override
    public void AddDepartment(Departments departments) {
        repository.save(departments);
    }

    @Override
    public void EditDepartment(DepartmentDTO departmentDTO) {
        Departments currentDepartment = repository.findById(departmentDTO.getDepartmentID()).orElse(null);
        if(currentDepartment != null){
            currentDepartment.setName(departmentDTO.getName());
            currentDepartment.setPhone(departmentDTO.getPhone());
            currentDepartment.setAddress(departmentDTO.getAddress());
            currentDepartment.setUserID(departmentDTO.getUserID());

            repository.save(currentDepartment);
        }
    }

    @Override
    public void DeleteDepartment(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> getAll() {
        List<Departments> departments = repository.findAll();
        return departments.stream().map(d -> convert(d)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO findById(String id) {
        Departments departments = repository.findById(id).orElse(null);
        return convert(departments);
    }

    @Override
    public DepartmentDTO convert(Departments departments) {
        return new ModelMapper().map(departments, DepartmentDTO.class);
    }
}
