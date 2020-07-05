package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.domain.dto.BookDTO;
import com.learning.ote.spring.mvc.exception.BookNotFoundException;
import com.learning.ote.spring.mvc.exception.errors.BookError;
import com.learning.ote.spring.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable("id") Long bookId) {
        BookDTO bookDTO = bookService.findById(bookId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<BookDTO>> findByTitle(@RequestParam("title") String bookTitle, @RequestParam(name = "category", required = false) String category) {
        List<BookDTO> bookDTOList = bookService.findByTitle(bookTitle);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDTOList);
    }

    @PostMapping
    public BookDTO create(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Book not found exception");
    }

//    @ExceptionHandler(BookNotFoundException.class)
//    public ResponseEntity<BookError> handleException() {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new BookError("Book not found exception", 1));
//    }

}
