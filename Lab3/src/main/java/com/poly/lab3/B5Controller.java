package com.poly.lab3;

import com.poly.lab3.Entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class B5Controller {
    @RequestMapping("/staff/control")
    public String staff(Model model){
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyen van user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyen van user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyen van user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyen van user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyen van user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyen van user6").level(0).build()
        );
        model.addAttribute("list",list);
        return "/demo/list-control";
    }
}
