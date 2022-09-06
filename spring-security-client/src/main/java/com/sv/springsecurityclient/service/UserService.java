package com.sv.springsecurityclient.service;

import com.sv.springsecurityclient.entity.User;
import com.sv.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
