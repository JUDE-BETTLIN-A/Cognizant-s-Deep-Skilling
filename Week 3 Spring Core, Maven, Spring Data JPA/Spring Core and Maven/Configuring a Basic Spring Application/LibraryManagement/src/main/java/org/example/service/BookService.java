package org.example.service;

import org.example.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Constructor for dependency injection
    public BookService() {
    }

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<String> getBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String book) {
        bookRepository.addBook(book);
        System.out.println("Book added: " + book);
    }

    public void displayAllBooks() {
        System.out.println("=== Library Management System ===");
        bookRepository.displayBooks();
    }
}