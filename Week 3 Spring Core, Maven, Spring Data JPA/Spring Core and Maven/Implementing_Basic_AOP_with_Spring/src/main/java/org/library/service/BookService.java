package org.library.service;

import org.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[INFO] Constructor Injection: BookRepository injected.");
    }

    public void addBook(String bookName) {
        System.out.println("[INFO] Inside BookService.addBook()");
        bookRepository.saveBook(bookName);
    }
}
