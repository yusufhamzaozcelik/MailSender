package com.mailSender.mailSender.service.Impl;

import com.mailSender.mailSender.model.Confirmation;
import com.mailSender.mailSender.model.User;
import com.mailSender.mailSender.repo.ConfirmationRepository;
import com.mailSender.mailSender.repo.UserRepository;
import com.mailSender.mailSender.service.EmailService;
import com.mailSender.mailSender.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;
    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exist!!");
        }
        user.setEnabled(false);
        userRepository.save(user);

        Confirmation confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);

     //   emailService.sendSimpleMailMessage(user.getName(),user.getEmail(),confirmation.getToken());
       // emailService.sendMimeMessageWithAttachments(user.getName(),user.getEmail(),confirmation.getToken());
        //emailService.sendMimeMessagesWithEmbeddedImages(user.getName(),user.getEmail(),confirmation.getToken());
        emailService.sendHtmlEmail(user.getName(),user.getEmail(),confirmation.getToken());
        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation= confirmationRepository.findByToken(token);
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
        return Boolean.TRUE;
    }
}
