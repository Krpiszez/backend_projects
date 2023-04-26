package com.libbioproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String author;
    @Column(nullable = false, length = 1000)
    private String description;
    @Column(nullable = false)
    private LocalDateTime publicationDate;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToOne
    private ImageFile imageFile;

}
