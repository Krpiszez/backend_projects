package com.libbioproject.controller;

import com.libbioproject.dto.ContactMessageDTO;
import com.libbioproject.dto.request.ContactMessageRequest;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.ContactMessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contactmessage")
@AllArgsConstructor
public class ContactMessageController {

    private ContactMessageService contactMessageService;

    @PostMapping("/visitors")
    public ResponseEntity<LResponse> saveContactMessage(@RequestBody @Valid ContactMessageRequest contactMessageRequest){
        contactMessageService.save(contactMessageRequest);
        LResponse response = new LResponse(ResponseMessage.CONTACT_MESSAGE_SAVE_RESPONSE, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ContactMessageDTO>> getAllDTO(){
        List<ContactMessageDTO> contactMessageDTOList = contactMessageService.getAllDTO();
        return ResponseEntity.ok(contactMessageDTOList);
    }
    @GetMapping("{id}")
    public ResponseEntity<ContactMessageDTO> getContactMessageByPath(@PathVariable Long id){
        ContactMessageDTO contactMessageDTO = contactMessageService.getContactMessageDTOById(id);
        return ResponseEntity.ok(contactMessageDTO);
    }
    @GetMapping("/request")
    public ResponseEntity<ContactMessageDTO> getContactMessageByParam(@RequestParam("id") Long id){
        ContactMessageDTO contactMessageDTO = contactMessageService.getContactMessageDTOById(id);
        return ResponseEntity.ok(contactMessageDTO);
    }
    @GetMapping("name")
    public ResponseEntity<ContactMessageDTO> getContactMessageByEmail(@RequestParam("email") String email){
        ContactMessageDTO contactMessageDTO = contactMessageService.getContactMessageDTOByEmail(email);
        return ResponseEntity.ok(contactMessageDTO);
    }


}
