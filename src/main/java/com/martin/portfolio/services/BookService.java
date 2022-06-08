package com.martin.portfolio.services;


import com.martin.portfolio.DAO.BookDAO;
import com.martin.portfolio.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public List<Book> getBooksByTitle(String title){
        return (List<Book>) bookDAO.getBooksByTitle(title);
    }
}
