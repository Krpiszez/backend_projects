package com.libbioproject.controller;

import com.libbioproject.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
@AllArgsConstructor
public class SubscriptionController {

    private SubscriptionService subscriptionService;


}
