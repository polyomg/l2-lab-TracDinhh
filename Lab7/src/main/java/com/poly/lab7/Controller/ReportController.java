package com.poly.lab7.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.Lab7.Entity.Report;
import poly.edu.Lab7.Jpa.ProductDAO;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ProductDAO productDao;

    @RequestMapping("/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = productDao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
