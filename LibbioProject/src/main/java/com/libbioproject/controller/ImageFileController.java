package com.libbioproject.controller;

import com.libbioproject.domain.ImageFile;
import com.libbioproject.dto.response.ImageSavedResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.ImageFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class ImageFileController {

    private ImageFileService imageFileService;

    @PostMapping("/uploadImage")//"36ceb1cc-e0e6-4403-aeee-de8319971a82"
    @PreAuthorize("(hasRole('ADMIN') or hasRole('LIBRARY_OWNER'))")
    public ResponseEntity<ImageSavedResponse> uploadCoverImage(@RequestParam("file") MultipartFile file){
        String imageId = imageFileService.saveImage(file);

        ImageSavedResponse response = new ImageSavedResponse(imageId, ResponseMessage.IMAGE_UPLOAD_RESPONSE_MESSAGE, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/downloadImage/{id}")
    public ResponseEntity<byte[]> downloadCoverImage(@PathVariable String id){
        ImageFile file = imageFileService.getImageById(id);
        byte[] image = file.getCoverImage().getImageData();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename="+file.getName()).body(image);
    }

    @PostMapping("/uploadContent")
    @PreAuthorize("(hasRole('ADMIN') or hasRole('LIBRARY_OWNER'))")
    public ResponseEntity<ImageSavedResponse> uploadBookContent (@RequestParam MultipartFile file){
        String imageId = imageFileService.saveContent(file);

        ImageSavedResponse response = new ImageSavedResponse(imageId, ResponseMessage.CONTENT_UPLOAD_RESPONSE_MESSAGE, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/downloadContent/{id}")
    @PreAuthorize("(hasRole('ADMIN') or hasRole('LIBRARY_OWNER'))")
    public ResponseEntity<byte[]> downloadBookContent(@PathVariable String id){
        ImageFile file = imageFileService.getContentById(id);
        byte[] image = file.getBookContent().getContentData();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename="+file.getName()).body(image);
    }




}
