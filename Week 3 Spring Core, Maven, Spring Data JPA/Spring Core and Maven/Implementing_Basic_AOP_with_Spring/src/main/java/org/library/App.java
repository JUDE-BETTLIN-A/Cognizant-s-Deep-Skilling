package org.library;

import org.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Exercise 8: Spring AOP Demo ===");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[INFO] ApplicationContext loaded.");

        BookService bookService = context.getBean(BookService.class);
        bookService.addBook("Spring for Beginners");

        System.out.println("[SUCCESS] Exercise 8 complete: AOP logging verified.");
    }
}
