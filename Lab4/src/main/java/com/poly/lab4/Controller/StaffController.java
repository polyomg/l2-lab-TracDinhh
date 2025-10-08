package com.poly.lab4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.lab4.Enity.Staff;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/create/form")
    public String form(Model model, @ModelAttribute("staff")Staff staff){
        model.addAttribute("message","Vui long nhap thong tin!");
        return "Demo/Staff-create";
    }

    @PostMapping("/create/save")
    public String save(Model model, @ModelAttribute("staff") Staff staff,
                       @RequestPart("photo_file")MultipartFile photoFile){

        if (!photoFile.isEmpty()){
            staff.setPhoto(photoFile.getOriginalFilename());
        }
        model.addAttribute("message", "Xin chao" + staff.getFullname() + "!");
        return "Demo/staff-create";
    }
}
