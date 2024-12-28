package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // Display all users
    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", users);
        return "user-list";
    }

    // Show create user form
    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    // Add a new user
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        users.add(user);
        return "redirect:/users/list";
    }

    // Delete a user
    @GetMapping("/delete/{index}")
    public String deleteUser(@PathVariable int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
        }
        return "redirect:/users/list";
    }
}
