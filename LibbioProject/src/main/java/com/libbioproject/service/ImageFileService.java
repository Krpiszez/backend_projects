package com.libbioproject.service;

import com.libbioproject.domain.BookContent;
import com.libbioproject.domain.CoverImage;
import com.libbioproject.domain.ImageFile;
import com.libbioproject.exception.ResourceNotFoundException;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.repository.ImageFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

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
}
