package com.libbioproject.service;

import com.libbioproject.mapper.ContactMessageMapper;
import com.libbioproject.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactMessageService {

    private ContactMessageRepository contactMessageRepository;

    private ContactMessageMapper contactMessageMapper;


}
