package com.martin.portfolio.DAO;

import com.martin.portfolio.models.Book;
import com.martin.portfolio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBooksByTitle(String title) {
        return (List<Book>) bookRepository.findBooksByTitle(title);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
