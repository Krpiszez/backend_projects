package com.libbioproject.service;

import com.libbioproject.repository.ImageFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageFileService {

    private ImageFileRepository imageFileRepository;

}
