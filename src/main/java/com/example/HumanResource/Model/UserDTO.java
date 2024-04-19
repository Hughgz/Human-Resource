package com.example.HumanResource.Model;

import com.example.HumanResource.Entity.Departments;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class UserDTO {
    private String userID;
    private String name;
    private String email;
    private String phone;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private int salary;
    private String username;
    private String password;
    private String managerID;
    private String departmentID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date closeDate;
    private String photo;
    private String position;
    private String status;
    private String contractType;
    private String roles;
    private Departments department;

    private MultipartFile file;
}
