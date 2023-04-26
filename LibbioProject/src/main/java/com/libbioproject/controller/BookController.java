package com.libbioproject.controller;

import com.libbioproject.domain.Book;
import com.libbioproject.dto.BookDTO;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/admin/{imageId}/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARY_OWNER')")
    public ResponseEntity<LResponse> saveBook(@PathVariable String imageId, @RequestBody BookDTO bookDTO){
        bookService.saveBook(imageId, bookDTO);
        LResponse response = new LResponse(ResponseMessage.BOOK_SAVED_RESPONSE_MESSAGE, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/visitors/all")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> bookDTOS = bookService.getAllBooks();
        return ResponseEntity.ok(bookDTOS);
    }
}
