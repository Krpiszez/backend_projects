package com.libbioproject.service;

import com.libbioproject.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

}
