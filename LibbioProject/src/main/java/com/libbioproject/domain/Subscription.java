package com.libbioproject.domain;

import com.libbioproject.domain.enums.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "t_subscription")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;
    @Column(nullable = false)
    private LocalDateTime subscriptionStartTime;
    @Column(nullable = false)
    private LocalDateTime subscriptionEndTime;
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private SubscriptionType subscriptionType;
    @Column(nullable = false)
    private Double totalPrice;



}
