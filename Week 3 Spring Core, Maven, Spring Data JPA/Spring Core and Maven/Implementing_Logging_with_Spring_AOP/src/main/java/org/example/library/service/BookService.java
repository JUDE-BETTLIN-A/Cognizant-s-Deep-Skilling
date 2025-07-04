package org.example.library.service;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    public void addBook() {
        System.out.println("Adding book...");
        // simulate processing
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
