package com.poly.lab6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.LAB6.Enity.Products;
import poly.edu.LAB6.Jpa.ProductDAO;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class SortController {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/sort")
    public String sort(Model model, @RequestParam("field")Optional<String> field){
        String sortField = field.orElse("price");

        Sort sort = Sort.by(Sort.Direction.DESC, sortField);
        List<Products> item = dao .findAll(sort);
        model.addAttribute("items",item);
        model.addAttribute("field", sortField.toUpperCase());
        return "product/sort";
    }
}
