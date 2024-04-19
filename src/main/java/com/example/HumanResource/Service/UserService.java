package com.example.HumanResource.Service;

import com.example.HumanResource.Entity.Users;
import com.example.HumanResource.Model.UserDTO;
import com.example.HumanResource.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository repository;
    @Override
    public void AddUser(UserDTO userDTO) {
        Users user = new ModelMapper().map(userDTO,Users.class);
        repository.save(user);
    }

    @Override
    public void EditUser(UserDTO userDTO) {
        Users currentUser = repository.findById(userDTO.getUserID()).orElse(null);
        if(currentUser != null){
            currentUser.setName(userDTO.getName());
            currentUser.setEmail(userDTO.getEmail());
            currentUser.setName(userDTO.getName());
            currentUser.setPhone(userDTO.getPhone());
            currentUser.setAddress(userDTO.getAddress());
            currentUser.setSalary(userDTO.getSalary());
            currentUser.setUsername(userDTO.getUsername());
            currentUser.setPassword(userDTO.getPassword());
            currentUser.setManagerID(userDTO.getManagerID());
            currentUser.setDepartmentID(userDTO.getDepartmentID());
            currentUser.setStartDate(userDTO.getStartDate());
            currentUser.setCloseDate(userDTO.getCloseDate());
            currentUser.setStatus(userDTO.getStatus());
            currentUser.setContractType(userDTO.getContractType());
            currentUser.setRoles(userDTO.getRoles());
            currentUser.setPosition(userDTO.getPosition());
            if (userDTO.getPhoto() != null)
                currentUser.setPhoto(userDTO.getPhoto());
            repository.save(currentUser);
        }
    }

    @Override
    public void DeleteUser(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDTO> GetAll() {
        List<Users> users = repository.findAll();
        return users.stream().map(u -> convert(u)).collect(Collectors.toList());
    }

    @Override
    public UserDTO FindUserByID(String id) {
        Users user = repository.findById(id).orElse(null);
        if(user != null){
            return convert(user);
        }
        return null;
    }

    @Override
    public UserDTO convert(Users u) {
        return new ModelMapper().map(u, UserDTO.class);
    }

    @Override
    public Boolean CheckPasswordUser(String email, String password) {
        Users user = repository.findUserByEmail(email);
        if(user.getPassword().equals(password))
            return true;
        return false;
    }

    @Override
    public Boolean CheckEmailUser(String email) {
        Users user = repository.findUserByEmail(email);
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public Users getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    @Override
    public String getNameByEmail(String email) {
        return repository.getNameByEmail(email);
    }

    @Override
    public String getPhotoByEmail(String email) {
        return repository.getPhotoName(email);
    }


}
