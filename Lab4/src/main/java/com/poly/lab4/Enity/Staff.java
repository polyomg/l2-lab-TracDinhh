package com.poly.lab4.Enity;

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
public class Staff {
    @Builder.Default
    private String id="";

    @Builder.Default
    private String fullname="";

    @Builder.Default
    private Boolean gender = null;

    @Builder.Default
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday= new Date();

    @Builder.Default
    private double salary=12345.6789;

    @Builder.Default
    private Integer level =0;

    @Builder.Default
    private String photo="photo.jpg";

}
