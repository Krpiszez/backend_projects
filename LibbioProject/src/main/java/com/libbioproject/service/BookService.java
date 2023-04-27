package com.libbioproject.service;

import com.libbioproject.domain.Book;
import com.libbioproject.domain.ImageFile;
import com.libbioproject.dto.BookDTO;
import com.libbioproject.exception.BadRequestException;
import com.libbioproject.exception.ConflictException;
import com.libbioproject.exception.ResourceNotFoundException;
import com.libbioproject.exception.message.ErrorMessage;
import com.libbioproject.mapper.BookMapper;
import com.libbioproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<BookDTO> getAllBooksWithPage(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        return bookPageToDTO(books);
    }

    private Page<BookDTO> bookPageToDTO(Page<Book> books){
        return books.map(b-> bookMapper.bookToBookDTO(b));
    }

    public BookDTO findBookById(Long id) {
        Book book = findBookPojoById(id);
        return bookMapper.bookToBookDTO(book);
    }

    private Book findBookPojoById(Long id) {
        return bookRepository.findBookById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id))
        );
    }

    public void updateBook(Long id, String imageId, BookDTO bookDTO) {
        Book book = findBookPojoById(id);
        isBuiltIn(book);
        ImageFile imageFile = imageFileService.findImageById(imageId);

        List<Book> bookList = bookRepository.findBooksByImageId(imageFile.getId());
        for (Book b: bookList){
            if (book.getId().longValue() != b.getId().longValue()){
                throw new ConflictException(ErrorMessage.IMAGE_USED_MESSAGE);
            }
        }
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setPublicationDate(bookDTO.getPublicationDate());
        book.setBuiltIn(bookDTO.isBuiltIn());
        book.setImageFile(imageFile);

        bookRepository.save(book);
    }

    public void removeBookById(Long id) {
        Book book = findBookPojoById(id);
        isBuiltIn(book);
    }

    private void isBuiltIn(Book book) {
        if (book.isBuiltIn()){
            throw new BadRequestException(ErrorMessage.NOT_PERMITTED_METHOD_MESSAGE);
        }
    }
}
