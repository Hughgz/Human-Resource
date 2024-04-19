package com.example.HumanResource.Service;

import com.example.HumanResource.Entity.Users;
import com.example.HumanResource.Model.UserDTO;

import java.util.List;

public interface IUserService {
    void AddUser(UserDTO userDTO);
    void EditUser(UserDTO userDTO);
    void DeleteUser(String id);
    List<UserDTO> GetAll();
    UserDTO FindUserByID(String id);

    UserDTO convert(Users u);

    Boolean CheckPasswordUser(String email, String password);
    Boolean CheckEmailUser(String email);

    Users getUserByEmail(String email);


    String getNameByEmail(String email);
    String getPhotoByEmail(String email);

}
