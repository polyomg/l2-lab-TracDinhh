package com.poly.lab8.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.Lab8.Service.MailService;

import java.io.File;
@Controller
@RequestMapping("/mail")
public class FormController {
    @Autowired
    private MailService mailService;

    // Thư mục lưu tạm (tạo folder này trong project hoặc dùng /tmp)
    private final String uploadDir = System.getProperty("java.io.tmpdir") + "/uploads";

    @GetMapping("/form")
    public String form(Model model) {
        return "mail/form"; // templates/mail/login.html
    }

    @PostMapping("/send")
    public String sendMail(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam(value = "cc", required = false) String cc,
            @RequestParam(value = "bcc", required = false) String bcc,
            @RequestParam(value = "subject", required = false) String subject,
            @RequestParam(value = "body", required = false) String body,
            @RequestParam(value = "mode", defaultValue = "send") String mode,
            @RequestParam(value = "attachments", required = false) MultipartFile[] attachments,
            Model model
    ) {
        try {
            // Tạo folder nếu chưa có
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) uploadFolder.mkdirs();

            // Lưu file lên server tạm thời, gom tên thành chuỗi phân cách bởi dấu phẩy
            StringBuilder filenames = new StringBuilder();
            if (attachments != null) {
                for (MultipartFile file : attachments) {
                    if (file != null && !file.isEmpty()) {
                        String original = file.getOriginalFilename();
                        // tạo tên file an toàn: timestamp + name
                        String storedName = System.currentTimeMillis() + "_" + original;
                        File dest = new File(uploadFolder, storedName);
                        file.transferTo(dest); // lưu file
                        if (filenames.length() > 0) filenames.append(",");
                        filenames.append(dest.getAbsolutePath());
                    }
                }
            }

            // Tạo Mail object (theo class MailService.Mail trong Lab8)
            MailService.Mail mail = MailService.Mail.builder()
                    .from(from)
                    .to(to)
                    .cc(cc)
                    .bcc(bcc)
                    .subject(subject)
                    .body(body)
                    .filenames(filenames.length() > 0 ? filenames.toString() : null)
                    .build();

            if ("send".equals(mode)) {
                // Gửi trực tiếp
                mailService.send(mail);
                model.addAttribute("message", "Mail của bạn đã được gửi.");
            } else {
                // Xếp vào hàng đợi
                mailService.push(mail);
                model.addAttribute("message", "Mail của bạn đã được xếp vào hàng đợi.");
            }

            // (Tùy chọn) xóa file tạm sau khi gửi — nếu MailServiceImpl đã đính kèm bằng đường dẫn
            // Note: nếu MailServiceImpl đang attach file bằng File path, thì không xóa trước khi send;
            // nếu xóa, hãy xóa sau khi chắc chắn mail được gửi (có thể trong MailServiceImpl).
            return "mail/form";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi: " + e.getMessage());
            return "mail/form";
        }
    }
}
