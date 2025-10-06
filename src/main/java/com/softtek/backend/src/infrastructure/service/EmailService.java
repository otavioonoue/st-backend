package com.softtek.backend.src.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.service.EmailSender;
import com.softtek.backend.src.infrastructure.exception.EmailSendException;

@Service
public class EmailService implements EmailSender {

    private final JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            throw new EmailSendException("Problem to send email");
        }
    }

    @Override
    public void sendToken(String to, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setSubject("[SOFTTEK] Token para acesso a conta");
            message.setText("Use esse token para ter acesso a sua conta! \n" + token);
            mailSender.send(message);
        } catch (Exception e) {
            throw new EmailSendException("Problem to send email");
        }
    }

    
}
