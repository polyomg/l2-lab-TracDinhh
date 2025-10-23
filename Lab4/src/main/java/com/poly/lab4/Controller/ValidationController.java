package com.poly.lab4.Controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.lab4.Enity.StaffValidation;

@Controller
@RequestMapping("/staff")
public class ValidationController {

    @GetMapping("/create/form2")
    public String form(@ModelAttribute("staff") StaffValidation staffValidation, Model model){
        model.addAttribute("message","Vui long nhap day du thong tin");
        return "Demo/Staff-validation";
    }

    @PostMapping("/create/save2")
    public String save(@Valid @ModelAttribute("staff") StaffValidation staffValidation,
                       Errors errors,
                       Model model,
                       @RequestPart("photo_file") MultipartFile photoFile){

        if (photoFile != null && !photoFile.isEmpty()) {
            staffValidation.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui long nhap thongtin ben duoi!");
            return "Demo/Staff-validation";
        }
        model.addAttribute("message", "Dữ liệu hợp lệ, xin chào " + staffValidation.getFullname() + "!");
        return "Demo/Staff-validation";
    }
}
