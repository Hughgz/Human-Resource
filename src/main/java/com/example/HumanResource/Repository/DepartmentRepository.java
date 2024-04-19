package com.example.HumanResource.Repository;

import com.example.HumanResource.Entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Departments, String> {
}
