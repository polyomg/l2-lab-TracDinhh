package com.poly.lab6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.LAB6.Enity.Products;
import poly.edu.LAB6.Jpa.ProductDAO;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDAO dao;

    @GetMapping("/page")
    public String page(Model model,
                       @RequestParam("p")Optional<Integer> p){
        int currentPage = p.orElse(0);
//        if (currentPage < 0) {
//            currentPage = 0;
//        }
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<Products> page = dao.findAll(pageable);

        model.addAttribute("page", page);
        return "page/productpage";
    }
}
