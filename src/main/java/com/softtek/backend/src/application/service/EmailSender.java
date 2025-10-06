package com.softtek.backend.src.application.service;

public interface EmailSender {
    void send(String to, String subject, String body);
    void sendToken(String to, String token);
}
