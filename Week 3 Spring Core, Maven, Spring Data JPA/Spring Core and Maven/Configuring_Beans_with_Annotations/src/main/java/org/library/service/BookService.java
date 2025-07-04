package org.library.service;

import org.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired  // Constructor or setter injection can be used
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[INFO] BookRepository injected via @Autowired.");
    }

    public void addBook(String bookName) {
        System.out.println("[INFO] Adding book using BookRepository...");
        bookRepository.saveBook(bookName);
    }
}
