package com.libbioproject.dto;

import com.libbioproject.domain.Library;
import com.libbioproject.domain.User;
import com.libbioproject.domain.enums.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {


    private Long id;

    private Long userId;

    private LibraryDTO libraryDTO;

    private LocalDateTime subscriptionStartTime;

    private LocalDateTime subscriptionEndTime;

    private SubscriptionType subscriptionType;

    private Double totalPrice;

}
