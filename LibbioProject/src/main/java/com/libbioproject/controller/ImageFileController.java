package com.libbioproject.controller;

import com.libbioproject.service.ImageFileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagefile")
@AllArgsConstructor
public class ImageFileController {

    private ImageFileService imageFileService;



}
