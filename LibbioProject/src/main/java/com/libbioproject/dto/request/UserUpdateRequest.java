package com.libbioproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest implements UpdateRequest{
    @Size(max = 50)
    @NotBlank(message = "Please provide your first name!")
    private String firstName;
    @Size(max = 50)
    @NotBlank(message = "Please provide your last name!")
    private String lastName;
    @Email(message = "Please provide a valid email!")
    @Size(min = 5, max = 80)
    private String email;
    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please provide valid phone number")
    @Size(min = 14, max = 14)
    @NotBlank(message = "Please provide your phone number!")
    private String phoneNumber;
    @Size(max = 100)
    @NotBlank(message = "Please provide your address!")
    private String address;
    @Size(max = 15)
    @NotBlank(message = "Please provide your zip code!")
    private String zipCode;

}
