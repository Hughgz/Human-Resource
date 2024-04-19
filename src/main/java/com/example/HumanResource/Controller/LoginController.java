package com.example.HumanResource.Controller;

import com.example.HumanResource.Entity.Users;
import com.example.HumanResource.Model.UserDTO;
import com.example.HumanResource.Repository.UserRepository;
import com.example.HumanResource.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    UserService service;

    @GetMapping("/login")
    public String LoginPage() {
        return "login.html";
    }

    @PostMapping("/login")
    public String PLoginPage(@ModelAttribute("user") UserDTO userDTO, HttpSession session, Model model) {
        String name = service.getNameByEmail(userDTO.getEmail());
        if (service.CheckEmailUser(userDTO.getEmail()) == false) {
            return "redirect:/login?emailWrong";
        }
        if (service.CheckPasswordUser(userDTO.getEmail(), userDTO.getPassword())) {
            session.setAttribute("name", name);
            return "redirect:/home?success";
        }
        return "redirect:/login?passwordWrong";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        // Xóa thông tin session của người dùng
        session.removeAttribute("name");
        return "redirect:/home";
    }
}
