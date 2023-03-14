package com.libbioproject.mapper;

import com.libbioproject.domain.ContactMessage;
import com.libbioproject.dto.ContactMessageDTO;
import com.libbioproject.dto.request.ContactMessageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMessageMapper {

    @Mapping(target = "id", ignore = true)
    ContactMessage contactMessageRequestToContactMessage(ContactMessageRequest contactMessageRequest);
    ContactMessageDTO contactMessageToDTO(ContactMessage contactMessage);
    List<ContactMessageDTO> contactMessageListToDTOList(List<ContactMessage> contactMessageList);

}
