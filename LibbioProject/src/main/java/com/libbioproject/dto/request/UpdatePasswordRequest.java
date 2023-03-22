package com.libbioproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordRequest {
    @NotBlank(message = "Please provide old password!")
    private String oldPassword;
    @NotBlank(message = "Please provide new password!")
    @Size(min = 4, max = 20)
    private String newPassword;

}
