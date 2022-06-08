package com.martin.portfolio.repository;

import com.martin.portfolio.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Collection<Book> findBooksByTitle(String title);
}
