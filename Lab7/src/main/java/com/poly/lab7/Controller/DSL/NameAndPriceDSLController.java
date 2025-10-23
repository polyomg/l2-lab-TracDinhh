package com.poly.lab7.Controller.DSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.Lab7.Entity.Product;
import poly.edu.Lab7.Jpa.ProductDAO;
import poly.edu.Lab7.Service.SessionService;

import java.util.Optional;

@Controller
public class NameAndPriceDSLController {

    @Autowired
    ProductDAO dao;

    @Autowired
    SessionService session;

    @RequestMapping("/product/search-and-page-dsl")
    public String searchAndPageDSL(Model model,
                                   @RequestParam("keywords") Optional<String> kw,
                                   @RequestParam("p") Optional<Integer> p) {

        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);

        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "DSL/search-and-page";
    }
}
