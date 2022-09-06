package com.sv.springsecurityclient.entity.listener;

import com.sv.springsecurityclient.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create the verification token for the user
    }
}
