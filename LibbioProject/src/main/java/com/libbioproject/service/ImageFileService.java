package com.libbioproject.service;

import com.libbioproject.domain.BookContent;
import com.libbioproject.domain.CoverImage;
import com.libbioproject.domain.ImageFile;
import com.libbioproject.dto.ImageFileDTO;
import com.libbioproject.exception.ResourceNotFoundException;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.repository.ImageFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImageFileService {

    private ImageFileRepository imageFileRepository;

    public String saveImage(MultipartFile file) {
        ImageFile imageFile = null;

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            CoverImage coverImage = new CoverImage(file.getBytes());
            imageFile = new ImageFile(fileName, file.getContentType(), coverImage);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        imageFileRepository.save(imageFile);
        return imageFile.getId();
    }

    public ImageFile getImageById(String id) {
        return imageFileRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException(String.format(ErrorMessage.IMAGE_NOT_FOUND_MESSAGE, id))
        );
    }

    public String saveContent(MultipartFile file) {
        ImageFile imageFile = null;

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            BookContent bookContent = new BookContent(file.getBytes());
            imageFile = new ImageFile(fileName, file.getContentType(), bookContent);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        imageFileRepository.save(imageFile);
        return imageFile.getId();
    }

    public ImageFile getContentById(String id) {
        return imageFileRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.IMAGE_NOT_FOUND_MESSAGE, id))
        );
    }

    public List<ImageFileDTO> getAllImages() {
        List<ImageFile> imageFileList = imageFileRepository.findAll();
        return imageFileList.stream().map(imageFile -> {
            String imageUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/displayImage")
                    .path(imageFile.getId()).toUriString();
            return new ImageFileDTO(imageFile.getName(), imageUri, imageFile.getType(), imageFile.getImageLength());
        }).collect(Collectors.toList());
    }

    public List<ImageFileDTO> getAllContents() {
        List<ImageFile> imageFileList = imageFileRepository.findAll();
        return imageFileList.stream().map(imageFile -> {
            String imageUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/displayContent")
                    .path(imageFile.getId()).toUriString();
            return new ImageFileDTO(imageFile.getName(), imageUri, imageFile.getType(), imageFile.getImageLength());
        }).collect(Collectors.toList());
    }

    public void removeImageFileById(String id) {
        imageFileRepository.deleteById(id);
    }
}
