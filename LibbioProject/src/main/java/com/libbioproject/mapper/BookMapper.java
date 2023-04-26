package com.libbioproject.mapper;

import com.libbioproject.domain.Book;
import com.libbioproject.domain.ImageFile;
import com.libbioproject.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "imageFile", ignore = true)
    Book bookDTOToBook(BookDTO bookDTO);

    List<BookDTO> bookListToBookDTOList(List<Book> bookList);

    @Mapping(source = "imageFile", target = "imageFile", qualifiedByName = "getImageAsString")
    BookDTO bookToBookDTO(Book book);

    @Named("getImageAsString")
    public static String getImageFileId(ImageFile imageFile){
        return imageFile.getId().toString();
    }

}
