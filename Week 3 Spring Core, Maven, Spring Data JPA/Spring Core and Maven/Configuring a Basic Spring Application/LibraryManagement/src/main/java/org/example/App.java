package org.example;
import org.example.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Load Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the application
        System.out.println("=== Spring Library Management System ===");
        System.out.println("Application started successfully!");
        System.out.println();

        // Display existing books
        bookService.displayAllBooks();
        System.out.println();

        // Add a new book
        bookService.addBook("Spring Boot in Action");
        System.out.println();

        // Display books again
        bookService.displayAllBooks();

        // Close context (for ClassPathXmlApplicationContext)
        ((ClassPathXmlApplicationContext) context).close();
    }
}
