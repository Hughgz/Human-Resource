package com.example.HumanResource.Controller;

import com.example.HumanResource.Entity.Users;
import com.example.HumanResource.Model.UserDTO;
import com.example.HumanResource.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;
    @GetMapping("/user")
    public String UserPage(Model model){
        List<UserDTO> users = service.GetAll();
        model.addAttribute("userList", users);
        return "users.html";
    }

    @GetMapping("/user/new")
    public String GUserNewPage(){
        return "user_new.html";
    }

    @GetMapping("/user/delete")
    public String GDeleteUser(@RequestParam("id") String userID){
        service.DeleteUser(userID);
        return "redirect:/user";
    }

    @GetMapping("/user/edit")
    public String GEditUser(Model model, @RequestParam("id") String userID){
        UserDTO userDTO = service.FindUserByID(userID);
        model.addAttribute("currentUser", userDTO);
        return "user_edit.html";
    }

    @PostMapping("/user/new")
    public String PUserNewPage(@Valid @ModelAttribute UserDTO u) throws IOException {
        if (!u.getFile().isEmpty())
            try {
                // khong luu file vao db
                // luu vao thu muc (folder) nao do
                File folder = new File("D:\\HumanResourceDashboard\\HumanResource\\uploads\\");
                if (!folder.exists())
                    folder.mkdirs();
                // ten file nguoi dung upload
                String filename = u.getFile().getOriginalFilename();
                // file nam ben trong folder
                File saveFile = new File(folder.getPath() + File.separator + filename);
                // copy toan bo vao saveFile
                u.getFile().transferTo(saveFile);

                // luu xuong db ten file
                u.setPhoto(filename);//
            } catch (IOException e) {
                e.printStackTrace();
            }
        service.AddUser(u);
        return "redirect:/user";
    }
    /*@GetMapping("/user/download/{filename}") // /123.jpg
    public void delete(@PathVariable("filename") String filename, HttpServletResponse resp) {
        try {
            File file = new File("D:\\HumanResourceDashboard\\HumanResource\\uploads\\" + filename);

            // tranfer file to resp trả về
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

            Files.copy(file.toPath(), resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    @GetMapping("/user/download")
    public void download(@RequestParam("filename") String filename, HttpServletResponse resp) throws IOException {
        File file = new File("D:\\HumanResourceDashboard\\HumanResource\\uploads\\" + filename);
        Files.copy(file.toPath()
                , resp.getOutputStream());
    }
    @PostMapping("/user/edit")
    public String PEditUser(@ModelAttribute @Valid UserDTO u){
        if (!u.getFile().isEmpty())
            try {
                // khong luu file vao db
                // luu vao thu muc (folder) nao do
                File folder = new File("D:\\HumanResourceDashboard\\HumanResource\\uploads\\");
                if (!folder.exists())
                    folder.mkdirs();
                // ten file nguoi dung upload
                String filename = u.getFile().getOriginalFilename();
                // file nam ben trong folder
                File saveFile = new File(folder.getPath() + File.separator + filename);
                // copy toan bo vao saveFile
                u.getFile().transferTo(saveFile);

                // luu xuong db ten file
                u.setPhoto(filename);//
            } catch (IOException e) {
                e.printStackTrace();
            }
        service.EditUser(u);
        return "redirect:/user";
    }
}
