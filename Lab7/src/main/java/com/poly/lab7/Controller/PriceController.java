package com.poly.lab7.Controller;

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
@RequestMapping("/product")
public class PriceController {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max){

        //nếu người dung ko nhập thì sẽ mặc đinh là 0
        double minPrice = min.orElse(0.0);
        //nếu người dùng ko nhập thì sẽ lây gia trị cao nhất không giới hạn
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> list = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", list);
        model.addAttribute("min", min.orElse(null));
        model.addAttribute("max", max.orElse(null));

        return "product/search";
    }
}
//Dùng Optional để tránh lỗi null nếu người dùng không nhập gì.
//Nếu có giá trị → lấy giá trị đó.
//Nếu không có → .orElse() sẽ cung cấp giá trị mặc định.
