package com.libbioproject.service;

import com.libbioproject.domain.ContactMessage;
import com.libbioproject.dto.ContactMessageDTO;
import com.libbioproject.dto.request.ContactMessageRequest;
import com.libbioproject.exception.ResourceNotFound;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.mapper.ContactMessageMapper;
import com.libbioproject.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactMessageService {

    private ContactMessageRepository contactMessageRepository;

    private ContactMessageMapper contactMessageMapper;


    public void save(ContactMessageRequest contactMessageRequest) {
        ContactMessage contactMessage = contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);
        contactMessageRepository.save(contactMessage);
    }

    public List<ContactMessageDTO> getAllDTO() {
        List<ContactMessage> contactMessageList = contactMessageRepository.findAll();
        return contactMessageMapper.contactMessageListToDTOList(contactMessageList);
    }

    private ContactMessage getContactMessageById(Long id){
        return contactMessageRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFound(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }

    public ContactMessageDTO getContactMessageDTOById(Long id) {
        ContactMessage contactMessage = getContactMessageById(id);
        return contactMessageMapper.contactMessageToDTO(contactMessage);
    }

    public ContactMessageDTO getContactMessageDTOByEmail(String email) {
        ContactMessage contactMessage = contactMessageRepository.findByEmail(email);
        return contactMessageMapper.contactMessageToDTO(contactMessage);
    }
}
