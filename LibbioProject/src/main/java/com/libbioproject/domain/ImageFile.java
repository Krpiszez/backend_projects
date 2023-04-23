package com.libbioproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_image_file")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageFile {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    private long imageLength;
    private long contentLength;
    @OneToOne(cascade = CascadeType.ALL)
    private CoverImage coverImage;
    @OneToOne(cascade = CascadeType.ALL)
    private BookContent bookContent;

    public ImageFile (String name, String type, CoverImage coverImage){
        this.name=name;
        this.type=type;
        this.coverImage = coverImage;
        this.imageLength = coverImage.getImageData().length;
    }

    public ImageFile (String name, String type, BookContent bookContent){
        this.name=name;
        this.type=type;
        this.bookContent = bookContent;
        this.contentLength = bookContent.getContentData().length;
    }

}
