package org.library;

import org.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Spring IoC Configuration Demo ===");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[INFO] Spring ApplicationContext loaded successfully.");

        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println("[INFO] BookService bean retrieved from Spring context.");

        bookService.addBook("Spring in Action");

        System.out.println("[SUCCESS] Exercise 5 completed: Spring IoC container configured and tested successfully.");
    }
}
