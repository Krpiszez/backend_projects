package com.libbioproject.service;

import com.libbioproject.domain.ContactMessage;
import com.libbioproject.dto.ContactMessageDTO;
import com.libbioproject.dto.request.ContactMessageRequest;
import com.libbioproject.exception.ResourceNotFoundException;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.mapper.ContactMessageMapper;
import com.libbioproject.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }

    public ContactMessageDTO getContactMessageDTOById(Long id) {
        ContactMessage contactMessage = getContactMessageById(id);
        return contactMessageMapper.contactMessageToDTO(contactMessage);
    }
    public ContactMessageDTO getContactMessageDTOByEmail(String email) {
        ContactMessage contactMessage = contactMessageRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE_EMAIL, email)));
        return contactMessageMapper.contactMessageToDTO(contactMessage);
    }
    public ContactMessage getContactMessageByName(String name){
        return contactMessageRepository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE_EMAIL, name)));
    }

    public void updateById(Long id, ContactMessageRequest contactMessageRequest) {
        ContactMessage contactMessageToUpdate = getContactMessageById(id);
        ContactMessage contactMessageNew = contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);

        contactMessageToUpdate.setName(contactMessageNew.getName());
        contactMessageToUpdate.setBody(contactMessageNew.getBody());
        contactMessageToUpdate.setEmail(contactMessageNew.getBody());
        contactMessageToUpdate.setSubject(contactMessageNew.getSubject());

        contactMessageRepository.save(contactMessageToUpdate);

    }
    public void updateByName(String name, ContactMessageRequest contactMessageRequest) {
        ContactMessage contactMessageToUpdate = getContactMessageByName(name);
        ContactMessage contactMessageNew = contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);

        contactMessageToUpdate.setName(contactMessageNew.getName());
        contactMessageToUpdate.setBody(contactMessageNew.getBody());
        contactMessageToUpdate.setEmail(contactMessageNew.getBody());
        contactMessageToUpdate.setSubject(contactMessageNew.getSubject());

        contactMessageRepository.save(contactMessageToUpdate);
    }
    public void deleteContactMessage(Long id) {
        ContactMessage contactMessage = getContactMessageById(id);
        contactMessageRepository.delete(contactMessage);
    }
    public Page<ContactMessageDTO> getAllByPage(Pageable pageable) {
        Page<ContactMessage> contactMessagePage = contactMessageRepository.findAll(pageable);
        return mapPageable(contactMessagePage);
    }
    private Page<ContactMessageDTO> mapPageable(Page<ContactMessage> contactMessagePage){
        return contactMessagePage.map(contactMessage -> contactMessageMapper.contactMessageToDTO(contactMessage));
    }
}
