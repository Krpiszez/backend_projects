package com.libbioproject.controller;

import com.libbioproject.domain.ImageFile;
import com.libbioproject.dto.ImageFileDTO;
import com.libbioproject.dto.response.ImageSavedResponse;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.ImageFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public ResponseEntity<ImageSavedResponse> uploadBookContent (@RequestParam("file") MultipartFile file){
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

    @GetMapping("displayImage/{id}")
    public ResponseEntity<byte[]> displayImage(@PathVariable String id){
        ImageFile imageFile = imageFileService.getImageById(id);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageFile.getCoverImage().getImageData(), header, HttpStatus.OK);
    }

    @GetMapping("displayContent/{id}")
    public ResponseEntity<byte[]> displayContent(@PathVariable String id){
        ImageFile imageFile = imageFileService.getImageById(id);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(imageFile.getBookContent().getContentData(), header, HttpStatus.OK);
    }

    @GetMapping("/images")
    @PreAuthorize("(hasRole('ADMIN') or hasRole('LIBRARY_OWNER'))")
    public ResponseEntity<List<ImageFileDTO>> getAllImages (){
        List<ImageFileDTO> imageFileDTOList = imageFileService.getAllImages();
        return ResponseEntity.ok(imageFileDTOList);
    }

    @GetMapping("/contents")
    @PreAuthorize("(hasRole('ADMIN') or hasRole('LIBRARY_OWNER'))")
    public ResponseEntity<List<ImageFileDTO>> getAllContents(){
        List<ImageFileDTO> imageFileDTOList = imageFileService.getAllContents();
        return ResponseEntity.ok(imageFileDTOList);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("(hasRole('ADMIN') or hasRole('LIBRARY_OWNER'))")
    public ResponseEntity<LResponse> deleteImageFile(@PathVariable String id){
        imageFileService.removeImageFileById(id);

        LResponse response = new LResponse(ResponseMessage.IMAGE_DELETE_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }




}
