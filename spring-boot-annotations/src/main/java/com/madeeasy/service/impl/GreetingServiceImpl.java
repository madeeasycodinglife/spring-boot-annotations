package com.madeeasy.service.impl;

import com.madeeasy.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet() {
        return "Hello";
    }
}
