package com.poly.lab8.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import poly.edu.Lab8.Intercrepter.AuthInterceptor;
import poly.edu.Lab8.Intercrepter.LogInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(
                        "/admin/**",
                        "/account/edit-profile",
                        "/account/change-password",
                        "/order/**")
                .excludePathPatterns("/admin/index"); // trang cho phép truy cập

        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/admin/**",
                        "/account/change-password",
                        "/account/edit-profile", "/order/**");

    }
}