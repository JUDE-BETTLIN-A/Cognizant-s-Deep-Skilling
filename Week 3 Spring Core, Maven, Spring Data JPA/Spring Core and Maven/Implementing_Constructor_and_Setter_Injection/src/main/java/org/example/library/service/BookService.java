package org.example.library.service;

import org.example.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String librarianName;

    // Constructor Injection
    public BookService(String librarianName) {
        this.librarianName = librarianName;
        System.out.println("Constructor Injection: Librarian Name set to " + librarianName);
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter Injection: BookRepository injected.");
    }

    public void issueBook(String title) {
        System.out.println("Librarian " + librarianName + " is issuing book: " + title);
        bookRepository.saveBook(title);
    }
}
