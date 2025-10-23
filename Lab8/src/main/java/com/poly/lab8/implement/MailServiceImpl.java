package com.poly.lab8.implement;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import poly.edu.Lab8.Service.MailService;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;

    // ✅ Hàng đợi lưu mail chờ gửi
    List<Mail> queue = Collections.synchronizedList(new ArrayList<>());

    // ✅ Hàm push thêm mail vào hàng đợi
    @Override
    public void push(Mail mail) {
        queue.add(mail);
    }

    // ✅ Bộ định lịch: cứ 500ms kiểm tra hàng đợi để gửi mail
    @Scheduled(fixedDelay = 500)
    public void run() {
        while (!queue.isEmpty()) {
            Mail mail = queue.remove(0); // lấy phần tử đầu
            this.send(mail); // gọi lại hàm send() ở dưới
        }
    }

    @Override
    public void send(Mail mail) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom(mail.getFrom());
            helper.setReplyTo(mail.getFrom());
            helper.setTo(mail.getTo());
            if (!isNullOrEmpty(mail.getCc())) helper.setCc(mail.getCc());
            if (!isNullOrEmpty(mail.getBcc())) helper.setBcc(mail.getBcc());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);

            String filenames = mail.getFilenames();
            if (!isNullOrEmpty(filenames)) {
                for (String filename : filenames.split("[,;]+")) {
                    File file = new File(filename.trim());
                    if (file.exists()) {
                        helper.addAttachment(file.getName(), file);
                    }
                }
            }
            mailSender.send(message);
            System.out.println("✅ Đã gửi mail tới: " + mail.getTo());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean isNullOrEmpty(String text) {
        return (text == null || text.trim().length() == 0);
    }
}
