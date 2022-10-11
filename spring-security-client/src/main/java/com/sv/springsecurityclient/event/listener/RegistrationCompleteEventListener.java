package com.sv.springsecurityclient.event.listener;

import com.sv.springsecurityclient.entity.User;
import com.sv.springsecurityclient.event.RegistrationCompleteEvent;
import com.sv.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create the verification token for the user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();

        userService.saveVerificationTokenForUser(token, user);

        // send mail to user
        String url = event.getApplicationURL() + "verifyRegistration?token="+token;

        // send verification email
        log.info("Click the link to verify your account: {}", url);
    }
}
