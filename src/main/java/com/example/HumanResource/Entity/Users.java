package com.example.HumanResource.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class Users {
    @Id
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

    @ManyToOne
    private Departments department;


}
