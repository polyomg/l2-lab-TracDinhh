package com.poly.lab1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/login/form")
    public String from(){
        return "Login";
    }

    @PostMapping("/login/check")
    public String login(Model model){
        String user = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(user) && "123".equals(password)){
            model.addAttribute("message","Login successfully");
            model.addAttribute("sucess","Poly 123");
        }
        else if(!"123".equals(password)){
            model.addAttribute("message","Sai pass");
        }else if (!"poly".equals(user)) {
            model.addAttribute("message","Sai user");
        }
        else{
            model.addAttribute("message","Login failed");
        }
        return "Login";
    }
}
