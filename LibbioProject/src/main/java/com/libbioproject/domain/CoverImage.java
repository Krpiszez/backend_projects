package com.libbioproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoverImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
