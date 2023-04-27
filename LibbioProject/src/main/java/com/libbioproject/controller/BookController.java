package com.libbioproject.controller;

import com.libbioproject.domain.Book;
import com.libbioproject.dto.BookDTO;
import com.libbioproject.dto.response.LResponse;
import com.libbioproject.dto.response.ResponseMessage;
import com.libbioproject.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/visitors/all") // ?? All books or all libraries ???
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> bookDTOS = bookService.getAllBooks();
        return ResponseEntity.ok(bookDTOS);
    }

    @GetMapping("/visitors/pages")
    public ResponseEntity<Page<BookDTO>> getAllBooksWithPage(@RequestParam("page") int page,
                                                           @RequestParam("size") int size,
                                                           @RequestParam("prop") String prop,
                                                           @RequestParam(value = "direction",
                                                                   required = false,
                                                                   defaultValue = "DESC")Sort.Direction direction){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<BookDTO> bookDTOS = bookService.getAllBooksWithPage(pageable);
        return ResponseEntity.ok(bookDTOS);
    }

    @GetMapping("/visitors/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        BookDTO bookDTO = bookService.findBookById(id);
        return ResponseEntity.ok(bookDTO);
    }

    @PutMapping("/admin/auth")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LResponse> updateBook(@RequestParam("id") Long id,
                                                @RequestParam("imageId") String imageId,
                                                @Valid @RequestBody BookDTO bookDTO){
        bookService.updateBook(id, imageId, bookDTO);
        LResponse response = new LResponse(ResponseMessage.BOOK_UPDATED_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/admin/{id}/auth")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LResponse> deleteBook(@PathVariable Long id){
        bookService.removeBookById(id);
        LResponse response = new LResponse(ResponseMessage.BOOK_DELETED_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }


}
