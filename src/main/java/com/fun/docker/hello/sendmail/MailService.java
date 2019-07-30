package com.fun.docker.hello.sendmail;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Async
    public void sendMail(String title, String url) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("zzzzhaoxy@163.com"); // 发送人邮箱
        mailMessage.setSubject(title); // 标题
        mailMessage.setTo("zzzhaoxy@163.com"); // 收件人邮箱
        mailMessage.setText(url); // 内容
        mailSender.send(mailMessage); // 发送
    }

    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(content);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String filename = file.getFilename();
            helper.addAttachment(filename, file);
            mailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
