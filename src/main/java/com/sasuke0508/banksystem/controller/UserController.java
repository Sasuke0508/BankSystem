package com.sasuke0508.banksystem.controller;

import com.sasuke0508.banksystem.entity.User;
import com.sasuke0508.banksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String loadHome(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(Model model, @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        User user = userService.processLogin(email, password);
        if(user == null){
            model.addAttribute("errorMessage", "Login information is incorrect!");
            return "login";
        }
        else{
            session.setAttribute("userLogin", user);
            if(user.getRole().equals("customer")){
                return "redirect:/customer";
            }
            else if(user.getRole().equals("employee")){
                return "redirect:/employee";
            }
        }
        return "login";
    }

    @PostMapping("/logout")
    public String hanleLogout(HttpSession session){
        session.removeAttribute("userLogin");
        return "redirect:/login";
    }
}
