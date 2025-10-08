package com.poly.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class B4ProductController {
    private List<Product> list = new ArrayList<>();

    @ModelAttribute("items")
    public List<Product> getItems() {
        return list;

    }

    @GetMapping("/product/form")
    public String form(Model model) {
        model.addAttribute("defaultProduct", new Product("ip16",2000.0));
        model.addAttribute("defaultProduct2", new Product("sámung",1000.0));
        model.addAttribute("product", new Product());
        return "Product4";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        model.addAttribute("defaultProduct", new Product("ip16",2000.0));
        model.addAttribute("defaultProduct2", new Product("samsung",1000.0));
        model.addAttribute("savedProduct",p);
        list.add(p);
        return "Product4";
    }
}
