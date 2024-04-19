package com.example.HumanResource.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Departments {
    @Id
    private String departmentID;
    private String name;
    private String phone;
    private String address;
    private String userID;

    @OneToMany
    private List<Users> users;
}
