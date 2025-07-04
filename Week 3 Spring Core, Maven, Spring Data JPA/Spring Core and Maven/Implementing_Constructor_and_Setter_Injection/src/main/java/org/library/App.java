package org.library;

import org.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Exercise 7: Constructor and Setter Injection ===");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[INFO] ApplicationContext loaded.");

        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println("[INFO] BookService bean retrieved.");

        bookService.addBook("Spring Boot in Practice");

        System.out.println("[SUCCESS] Exercise 7 complete: Constructor and Setter injection verified.");
    }
}
