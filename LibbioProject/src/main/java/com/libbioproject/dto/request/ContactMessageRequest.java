package com.libbioproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageRequest {
    @Size(min = 2, max = 50, message = "Name '${validatedValue}' must be between {min} and {max} chars long!")
    @NotBlank(message = "Please enter a name!")
    private String name;
    @Size(min = 4, max = 50, message = "Subject '${validatedValue}' must be between {min} and {max} chars long!")
    @NotBlank(message = "Please enter a Subject!")
    private String subject;
    @Size(min = 10, max = 200, message = "Body '${validatedValue}' must be between {min} and {max} chars long!")
    @NotBlank(message = "Please enter your message!")
    private String body;
    @Email(message = "Please enter a valid Email address!")
    @NotBlank(message = "Please enter an Email address!")
    private String email;

}
