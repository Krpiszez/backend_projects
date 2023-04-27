package com.libbioproject.dto;

import com.libbioproject.domain.ImageFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {


    private Long id;
    @Size(min = 4, max = 50, message = "Size ${validatedValue} must be between {min} and {max} chars long!")
    @NotBlank(message = "Author can not be null!")
    private String author;
    @Size(min = 100, max = 1000, message = "Size ${validatedValue} must be between {min} and {max} chars long!")
    @NotBlank(message = "Description can not be null!")
    private String description;
    @Size(min = 4, max = 50, message = "Size ${validatedValue} must be between {min} and {max} chars long!")
    @NotBlank(message = "Date can not be null!")
    private LocalDateTime publicationDate;
    @Size(min = 4, max = 50, message = "Size ${validatedValue} must be between {min} and {max} chars long!")
    @NotBlank(message = "Book name can not be null!")
    private String name;
    @NotBlank(message = "Set the user!")
    private boolean builtIn;

    private String imageFile;


}
