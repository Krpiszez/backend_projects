package com.libbioproject.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libbioproject.domain.enums.SubscriptionType;
import com.libbioproject.dto.LibraryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    @NotBlank(message = "Provide a date")
    private LocalDateTime subscriptionStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    @NotBlank(message = "Provide a date")
    private LocalDateTime subscriptionEndTime;

}
