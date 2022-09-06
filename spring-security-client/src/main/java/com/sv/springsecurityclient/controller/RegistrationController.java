package com.sv.springsecurityclient.controller;

import com.sv.springsecurityclient.entity.User;
import com.sv.springsecurityclient.event.RegistrationCompleteEvent;
import com.sv.springsecurityclient.model.UserModel;
import com.sv.springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public RegistrationController(UserService userService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, "url"));
        return "Success";
    }
}
