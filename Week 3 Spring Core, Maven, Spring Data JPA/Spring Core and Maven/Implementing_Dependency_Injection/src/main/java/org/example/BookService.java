package org.example;


import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Default constructor (required for Spring)
    public BookService() {
        System.out.println("BookService: Default constructor called");
    }

    // Constructor-based Dependency Injection (optional)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor with BookRepository called");
    }

    // Setter-based Dependency Injection (PRIMARY METHOD)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: setBookRepository() called - Dependency Injected!");
    }

    // Getter for testing purposes
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    // Business methods
    public List<String> getAllBooks() {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not injected!");
        }
        return bookRepository.getAllBooks();
    }

    public void addBook(String book) {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not injected!");
        }
        bookRepository.addBook(book);
        System.out.println("BookService: Book added successfully - " + book);
    }

    public void displayAllBooks() {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not injected!");
        }
        System.out.println("=== Library Management System ===");
        System.out.println("Total books: " + bookRepository.getAllBooks().size());
        bookRepository.displayBooks();
    }

    public void searchBook(String keyword) {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not injected!");
        }

        List<String> books = bookRepository.getAllBooks();
        System.out.println("Searching for books containing: " + keyword);
        boolean found = false;

        for (String book : books) {
            if (book.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found containing: " + keyword);
        }
    }

    // Method to verify dependency injection
    public void verifyDependencyInjection() {
        if (bookRepository != null) {
            System.out.println("✓ Dependency Injection SUCCESS: BookRepository is injected");
            System.out.println("✓ BookRepository class: " + bookRepository.getClass().getSimpleName());
        } else {
            System.out.println("✗ Dependency Injection FAILED: BookRepository is null");
        }
    }
}