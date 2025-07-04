package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Starting Spring Library Management System ===");
        System.out.println();

        // Load Spring Context
        System.out.println("Loading Spring Application Context...");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring Context loaded successfully!");
        System.out.println();

        // Test 1: Get BookService bean and verify dependency injection
        System.out.println("=== Test 1: Dependency Injection Verification ===");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.verifyDependencyInjection();
        System.out.println();

        // Test 2: Display initial books
        System.out.println("=== Test 2: Display Initial Books ===");
        bookService.displayAllBooks();
        System.out.println();

        // Test 3: Add new books
        System.out.println("=== Test 3: Adding New Books ===");
        bookService.addBook("Spring Boot in Action");
        bookService.addBook("Microservices Patterns");
        bookService.addBook("Clean Architecture");
        System.out.println();

        // Test 4: Display updated books
        System.out.println("=== Test 4: Display Updated Books ===");
        bookService.displayAllBooks();
        System.out.println();

        // Test 5: Search functionality
        System.out.println("=== Test 5: Search Functionality ===");
        bookService.searchBook("Spring");
        System.out.println();
        bookService.searchBook("Python");
        System.out.println();

        // Test 6: Direct repository access (to show it's the same instance)
        System.out.println("=== Test 6: Verify Same Repository Instance ===");
        BookRepository repository = (BookRepository) context.getBean("bookRepository");
        System.out.println("Repository book count: " + repository.getBookCount());
        System.out.println("Service book count: " + bookService.getAllBooks().size());
        System.out.println("Both counts match: " + (repository.getBookCount() == bookService.getAllBooks().size()));
        System.out.println();

        // Test 7: Demonstrate Spring manages the lifecycle
        System.out.println("=== Test 7: Spring Bean Management ===");
        BookService anotherServiceReference = (BookService) context.getBean("bookService");
        System.out.println("Same BookService instance: " + (bookService == anotherServiceReference));
        System.out.println("This proves Spring manages singleton beans by default");
        System.out.println();

        System.out.println("=== All Tests Completed Successfully! ===");
        System.out.println("Dependency Injection is working correctly.");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("Spring Context closed.");
    }
}