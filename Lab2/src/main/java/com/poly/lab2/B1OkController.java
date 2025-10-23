package com.poly.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
public class B1OkController {

    @RequestMapping("/ok")
    public String ok(){
        return "OK";
    }

    @PostMapping("/ok")
    public String m1(Model model){
        model.addAttribute("message","m1");
        return "OK";
    }

    @GetMapping("/ok")
    public String m2(Model model){
        model.addAttribute("message","m2");
        return "OK";
    }

    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("message", "m3");
        return "OK";
    }

}
