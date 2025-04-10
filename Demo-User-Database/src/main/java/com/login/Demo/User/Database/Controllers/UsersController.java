package com.login.Demo.User.Database.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.login.Demo.User.Database.Entities.User;
import com.login.Demo.User.Database.Repositories.UserRepository;

@Controller
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String showAllUsers(ModelMap model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "usersList";
    }

}
