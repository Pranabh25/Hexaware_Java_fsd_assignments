package com.ecom.logistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.logistics.model.User;
import com.ecom.logistics.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Show login page
    @GetMapping("/")
    public String showLogin() {
        return "login"; // Assumes there is a login view
    }

    // Handle login form submission
    @PostMapping("/login-form")
    public String handleLogin(HttpServletRequest req, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            boolean isValidUser = userService.verifyLogin(username, password);
            if (isValidUser) {
                session.setAttribute("username", username);
                List<User> users = userService.getAllUsers();
                req.setAttribute("listUsers", users);
                return "user_dashboard"; // Redirect to user dashboard
            } else {
                req.setAttribute("msg", "Invalid username or password");
                return "login";
            }
        } catch (Exception e) {
            req.setAttribute("msg", "An error occurred");
            return "login";
        }
    }

    // Redirect to user dashboard (after login or initially)
    @GetMapping("/user-dashboard")
    public String goToUserDashboard(HttpServletRequest req, HttpSession session) {
        List<User> users = userService.getAllUsers();
        req.setAttribute("listUsers", users);
        return "user_dashboard";
    }

    // Add new user
    @PostMapping("/add")
    public String addUser(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        userService.saveUser(user);
        return "redirect:/users/user-dashboard";
    }

    // Soft delete user
    @GetMapping("/soft-delete/{id}")
    public String softDeleteUser(@PathVariable Long id) {
        userService.softDeleteUser(id);
        return "redirect:/users/user-dashboard";
    }

    // Hard delete user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/user-dashboard";
    }
}
