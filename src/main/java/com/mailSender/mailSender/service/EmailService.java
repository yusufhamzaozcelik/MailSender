package com.mailSender.mailSender.service;

public interface EmailService {

    void sendSimpleMailMessage(String name, String to, String token);
    void sendMimeMessageWithAttachments(String name, String to, String token);
    void sendMimeMessagesWithEmbeddedImages(String name, String to, String token);
    void sendMimeMessagesWithEmbeddedFiles(String name, String to, String token);
    void sendHtmlEmail(String name, String to, String token);
    void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token);
}
