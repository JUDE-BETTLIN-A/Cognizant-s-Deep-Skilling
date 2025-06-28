package org.example;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Main application is running.");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

}
