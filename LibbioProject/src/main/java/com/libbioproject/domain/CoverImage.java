package com.libbioproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_cover_image")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoverImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @Lob
    private byte[] imageData;
    public CoverImage(byte[] data){
        this.imageData = data;
    }
    private CoverImage(Long id){
        this.id = id;
    }

}
