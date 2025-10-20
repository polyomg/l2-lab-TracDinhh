package com.poly.lab7.Controller.DSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.Lab7.Entity.Product;
import poly.edu.Lab7.Jpa.ProductDAO;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductDSLController {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/DSL/product/search")
    public String search(Model model,
                         @RequestParam("min")Optional<Double> min,
                         @RequestParam("max")Optional<Double> max){

        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> item = dao.findByPriceBetween(minPrice,maxPrice);

        model.addAttribute("items",item);
        return "DSL/search";
    }
}
