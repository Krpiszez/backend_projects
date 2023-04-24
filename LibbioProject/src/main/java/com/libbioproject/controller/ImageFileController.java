package com.libbioproject.controller;

import com.libbioproject.dto.response.ImageSavedResponse;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.ImageFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagefile")
@AllArgsConstructor
public class ImageFileController {

    private ImageFileService imageFileService;

    @PostMapping("/upload")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ImageSavedResponse> uploadFile(@RequestParam("file") MultipartFile file){
        String imageId = imageFileService.saveImage(file);

        ImageSavedResponse response = new ImageSavedResponse(imageId, ResponseMessage.IMAGE_UPLOAD_RESPONSE_MESSAGE, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
