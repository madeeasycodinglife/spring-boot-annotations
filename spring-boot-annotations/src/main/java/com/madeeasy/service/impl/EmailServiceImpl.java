package com.madeeasy.service.impl;

import com.madeeasy.service.EmailService;

public class EmailServiceImpl implements EmailService {
    public EmailServiceImpl() {
        System.out.println("EmailServiceImpl constructor called with no args");
    }

    @Override
    public void sendEmail(String email) {
        System.out.println("email = " + email);
    }

}
