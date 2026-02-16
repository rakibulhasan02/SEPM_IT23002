package com.example.TestSpringJPA;


//package com.example.springdbweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // READ
    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", service.getAllUsers());
        model.addAttribute("userForm", new User()); // insert form এর জন্য
        return "user-list";
    }

    // INSERT
    @PostMapping("/users")
    public String add(@ModelAttribute("userForm") User user) {
        service.saveUser(user);
        return "redirect:/users";
    }

    // DELETE (Simple POST)
    @PostMapping("/users/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

    // UPDATE - show form
    @GetMapping("/users/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "edit-user";
    }

    // UPDATE - submit
    @PostMapping("/users/update")
    public String update(@ModelAttribute User user) {
        service.saveUser(user); // id থাকলে update হবে
        return "redirect:/users";
    }
}
