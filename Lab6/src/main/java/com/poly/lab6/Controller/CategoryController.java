package com.poly.lab6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.LAB6.Enity.Categories;
import poly.edu.LAB6.Jpa.CategoryDAO;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDAO dao;

    @GetMapping("/index")
    public String form(Model model){
        model.addAttribute("item",new Categories());
        model.addAttribute("items",dao.findAll());
        return "category/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") Categories item){
        dao.save(item);
        return "redirect:/category/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        dao.deleteById(id);
        return "redirect:/category/index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("item") Categories item) {
        dao.save(item);
        return "redirect:/category/edit/" + item.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        Categories item = dao.findById(id).orElse(new Categories());
        model.addAttribute("item",item);
        model.addAttribute("items",dao.findAll());
        return "category/index";
    }


}
