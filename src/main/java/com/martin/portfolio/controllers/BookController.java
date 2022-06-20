package com.martin.portfolio.controllers;

import com.martin.portfolio.models.Book;
import com.martin.portfolio.payload.response.MessageResponse;
import com.martin.portfolio.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return MessageResponse.generateResponse("Item succesvol toegevoegd", HttpStatus.OK, null);
    }

    @GetMapping("/getBooks")
    @ResponseBody
    public Object getBooks() {
        try {
            return bookService.getAllBooks();
        } catch (Exception e) {
            return MessageResponse.generateResponse("An error has occurred: " + e, HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/getBooksByTitle")
    @ResponseBody
    public Object getBookByTitle(@RequestParam String title) {
        try {
            return bookService.getBooksByTitle(title);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
