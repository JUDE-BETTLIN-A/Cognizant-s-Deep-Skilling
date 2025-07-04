package org.library;

import org.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Annotation-Based Bean Configuration ===");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[INFO] ApplicationContext loaded via XML with component scanning.");

        BookService bookService = context.getBean(BookService.class);
        System.out.println("[INFO] BookService bean retrieved via @Service annotation.");

        bookService.addBook("Spring in Action");

        System.out.println("[SUCCESS] Exercise 6 completed: Beans configured using annotations.");
    }
}

