package com.poly.lab8.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import poly.edu.Lab8.Service.MailService;

@Controller
public class MailController {
    @Autowired MailService mailService;

    @ResponseBody
    @RequestMapping("/mail/send")
    public String send() {
        try {
            mailService.send("receiver@gmail.com", "Subject", "<h3>Body</h3>");
            return "Mail đã gửi";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping("/mail/send-queue")
    public String sendByQueue() {
        try {
            mailService.push("receiver@gmail.com", "Subject (Queue)", "<h3>Nội dung mail từ hàng đợi</h3>");
            return "📩 Mail đã được xếp vào hàng đợi (sẽ tự động gửi sau vài giây)";
        } catch (Exception e) {
            return " Lỗi: " + e.getMessage();
        }
    }

}



