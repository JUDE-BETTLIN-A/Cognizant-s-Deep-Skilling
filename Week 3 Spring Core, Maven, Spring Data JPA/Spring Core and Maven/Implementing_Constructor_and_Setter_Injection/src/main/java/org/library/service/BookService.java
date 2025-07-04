package org.library.service;

import org.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String ownerName; // Extra property for setter injection demo

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[INFO] Constructor Injection: BookRepository injected.");
    }

    // Setter for setter injection
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        System.out.println("[INFO] Setter Injection: ownerName set to \"" + ownerName + "\"");
    }

    public void addBook(String bookName) {
        System.out.println("[INFO] Adding book with owner \"" + ownerName + "\"...");
        bookRepository.saveBook(bookName);
    }
}
