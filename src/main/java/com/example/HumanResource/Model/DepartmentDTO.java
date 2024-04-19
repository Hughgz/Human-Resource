package com.example.HumanResource.Model;

import com.example.HumanResource.Entity.Users;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class DepartmentDTO {
    private String departmentID;
    private String name;
    private String phone;
    private String address;
    private String userID;
    private List<Users> users;
}
