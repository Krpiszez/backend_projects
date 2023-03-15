package com.libbioproject.controller;

import com.libbioproject.dto.ContactMessageDTO;
import com.libbioproject.dto.request.ContactMessageRequest;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.ContactMessageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @PutMapping("{id}")
    public ResponseEntity<LResponse> updateContactMessageById(@PathVariable Long id,
                                                              @RequestBody @Valid ContactMessageRequest contactMessageRequest){
        contactMessageService.updateById(id, contactMessageRequest);
        LResponse response = new LResponse(ResponseMessage.CONTACT_MESSAGE_UPDATE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<LResponse> updateContactMessageByName(@RequestParam("name") String name,
                                                                @RequestBody @Valid ContactMessageRequest contactMessageRequest){
        contactMessageService.updateByName(name, contactMessageRequest);
        LResponse response = new LResponse(ResponseMessage.CONTACT_MESSAGE_UPDATE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<LResponse> deleteContactMessageById(@PathVariable Long id){
        contactMessageService.deleteContactMessage(id);
        LResponse response = new LResponse(ResponseMessage.CONTACT_MESSAGE_DELETE_RESPONSE, true);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<ContactMessageDTO>> getAllDTO(@RequestParam("page") int page,
                                                             @RequestParam("size") int size,
                                                             @RequestParam("sort") String prop,
                                                             @RequestParam(value = "direction",
                                                             required = false,
                                                             defaultValue = "DESC")Sort.Direction direction){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<ContactMessageDTO> contactMessageDTOPage = contactMessageService.getAllByPage(pageable);
        return ResponseEntity.ok(contactMessageDTOPage);
    }


}
