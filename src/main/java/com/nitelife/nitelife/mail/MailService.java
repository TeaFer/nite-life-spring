package com.nitelife.nitelife.mail;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private MailSender mailSender;
    private SimpleMailMessage defaultMailMessage;

    @Autowired
    public void MailService(MailSender mailSender, SimpleMailMessage defaultMailMessage) {
        this.mailSender = mailSender;
        this.defaultMailMessage = defaultMailMessage;
    }

    public void sendMail(String to, String subject, String text) {
        JavaMailSenderImpl a = (JavaMailSenderImpl)mailSender;
        System.out.println((a.getUsername()));
        defaultMailMessage.setTo(to);
        defaultMailMessage.setSubject(subject);
        defaultMailMessage.setText(text);
        mailSender.send(defaultMailMessage);
    }



}
