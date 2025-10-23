package com.poly.lab5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.Lab5.CookieService;
import poly.edu.Lab5.ParamService;
import poly.edu.Lab5.SessionService;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/form")
    public String form(){
        return "/Bai2/Login";
    }

    @PostMapping("/save")
    public String save(Model model){
        String username = paramService.getString("username","");
        String password = paramService.getString("password","");
        boolean remember = paramService.getBoolean("remember",false);

        if (username.equals("poly") && password.equals("123")){
            sessionService.set("username",username);
            if (remember){
                cookieService.add("user",username, 24 * 10);
                model.addAttribute("message","Luu thanh cong");
            }else {
                cookieService.remove("user");
                model.addAttribute("message","Luu that bai");
            }
            return "/Bai2/Login";
        }
        return "/Bai2/Login";
    }

}
