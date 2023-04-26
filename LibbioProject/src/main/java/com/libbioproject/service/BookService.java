package com.libbioproject.service;

import com.libbioproject.domain.Book;
import com.libbioproject.domain.ImageFile;
import com.libbioproject.dto.BookDTO;
import com.libbioproject.exception.ConflictException;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.mapper.BookMapper;
import com.libbioproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    private ImageFileService imageFileService;

    private BookMapper bookMapper;

    public void saveBook(String imageId, BookDTO bookDTO) {
        ImageFile imageFile = imageFileService.findImageById(imageId);
        Integer usedBookCount = bookRepository.findBookCountByImageId(imageId);
        if (usedBookCount>0){
            throw new ConflictException(ErrorMessage.IMAGE_USED_MESSAGE);
        }
        Book book = bookMapper.bookDTOToBook(bookDTO);
        book.setImageFile(imageFile);
        bookRepository.save(book);
    }

    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookMapper.bookListToBookDTOList(bookList);
    }
}
