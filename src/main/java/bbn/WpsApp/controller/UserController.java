package bbn.WpsApp.controller;

import bbn.WpsApp.entity.User;
import bbn.WpsApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name);
        user.setEmail(email);
        userService.saveUser(user);
        return "redirect:/users";
    }

}
