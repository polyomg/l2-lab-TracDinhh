package com.poly.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/param")
public class B2ParamController {

    @GetMapping("/form")
    public String form(){
        return "Param";
    }

    @PostMapping("/save/{x}")
    public String save(@PathVariable("x") String x,
                       @RequestParam("y") String y,
                       Model model){
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "Param";
    }

}
