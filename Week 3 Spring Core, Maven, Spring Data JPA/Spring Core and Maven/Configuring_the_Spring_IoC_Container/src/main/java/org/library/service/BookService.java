package org.library.service;

import org.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[INFO] BookRepository injected into BookService via setter.");
    }

    public void addBook(String bookName) {
        System.out.println("[INFO] Adding book using injected BookRepository...");
        bookRepository.saveBook(bookName);
    }
}
