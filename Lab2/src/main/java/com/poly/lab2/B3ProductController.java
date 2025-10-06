package com.poly.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class B3ProductController {

    @GetMapping("/form3")
    public String form(Product product){
        product.setName("iPhone 30");
        product.setPrice(20.0);
        return "Product3";
    }

    @PostMapping("/check3")
    public String check(@ModelAttribute Product product, Model model){
        model.addAttribute("product", product);
        return "Product3";
    }
}
