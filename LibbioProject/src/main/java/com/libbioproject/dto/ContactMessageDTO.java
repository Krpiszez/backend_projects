package com.libbioproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageDTO {

    private Long id;
    private String name;
    private String subject;
    private String body;
    private String email;
}
