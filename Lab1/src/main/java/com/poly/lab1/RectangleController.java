package com.poly.lab1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/rect/form")
    public String form(){
        return "Rectangle";
    }

    @PostMapping("/rect/check")
    public String check(Model model){
        Double w = Double.parseDouble(request.getParameter("width"));
        Double h = Double.parseDouble(request.getParameter("height"));
        double dientich = w * h;
        double chuvi = 2 * (w + h);
        model.addAttribute("result", "Diện tích: " + dientich + ", Chu vi: " + chuvi);
        return "Rectangle";
    }
}
