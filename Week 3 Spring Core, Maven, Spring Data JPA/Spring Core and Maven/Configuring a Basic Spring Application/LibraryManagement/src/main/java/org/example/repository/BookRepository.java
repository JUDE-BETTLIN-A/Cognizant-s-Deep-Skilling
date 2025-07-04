package org.example.repository;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<String> books;

    public BookRepository() {
        this.books = new ArrayList<>();
        // Initialize with some sample books
        books.add("Spring in Action");
        books.add("Java: The Complete Reference");
        books.add("Clean Code");
    }

    public List<String> getAllBooks() {
        return books;
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in repository:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }
}
