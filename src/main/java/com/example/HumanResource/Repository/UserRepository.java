package com.example.HumanResource.Repository;

import com.example.HumanResource.Entity.Users;
import com.example.HumanResource.Model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, String> {
    Users findUserByEmail(String email);
    Users getUserByEmail(String email);

    @Query("select u.name from Users u where u.email = :email")
    String getNameByEmail(@Param("email") String email);
    @Query("select u.photo from Users u where u.email = :email")
    String getPhotoName(@Param("email") String email);
}
