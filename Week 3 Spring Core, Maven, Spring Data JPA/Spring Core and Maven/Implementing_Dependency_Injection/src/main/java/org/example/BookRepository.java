package org.example;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<String> books;

    public BookRepository() {
        System.out.println("BookRepository: Constructor called");
        this.books = new ArrayList<>();
        initializeBooks();
    }

    private void initializeBooks() {
        // Initialize with some sample books
        books.add("Spring in Action");
        books.add("Java: The Complete Reference");
        books.add("Clean Code");
        books.add("Design Patterns");
        books.add("Effective Java");
        System.out.println("BookRepository: Initialized with " + books.size() + " books");
    }

    public List<String> getAllBooks() {
        return new ArrayList<>(books); // Return copy to prevent external modification
    }

    public void addBook(String book) {
        if (book != null && !book.trim().isEmpty()) {
            books.add(book);
            System.out.println("BookRepository: Book added to repository - " + book);
        } else {
            System.out.println("BookRepository: Invalid book title provided");
        }
    }

    public boolean removeBook(String book) {
        boolean removed = books.remove(book);
        if (removed) {
            System.out.println("BookRepository: Book removed - " + book);
        } else {
            System.out.println("BookRepository: Book not found - " + book);
        }
        return removed;
    }

    public void displayBooks() {
        System.out.println("Books in repository:");
        if (books.isEmpty()) {
            System.out.println("  No books available");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + books.get(i));
            }
        }
    }

    public int getBookCount() {
        return books.size();
    }

    public boolean hasBook(String book) {
        return books.contains(book);
    }
}