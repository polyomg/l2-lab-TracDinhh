package com.poly.lab3;

import com.poly.lab3.Entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffController {

    @RequestMapping("/staff/detail")
    public String detail(Model model){
        Staff staff = Staff.builder()
                .id("user@gamil.com")
                .fullname("nguyễn văn user")
                .level(2)
                .salary(20000.0)
                .gender(false)
                .build();
        model.addAttribute("staff",staff);
        return "demo/staff-detail";
    }
}
