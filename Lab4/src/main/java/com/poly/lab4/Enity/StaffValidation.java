package com.poly.lab4.Enity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffValidation {
    @NotBlank(message = "Email khong duoc de trong")
    @Email(message = "Khong dung dinh dang")
    private String id;

    @NotBlank(message = "Khong duoc de trong ho ten")
    private String fullname;

    @NotNull(message = "Phai chon gioi tinh")
    private Boolean gender;

    @NotNull(message = "Phai nhap ngay sinh")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;

    @NotNull(message = "Phai nhap luong")
    @Min(value = 1000, message = "Luong phai lon hon hoac bang 1000")

    private Double salary;
    private Integer level;
    private String photo = "photo.jpg";
}
