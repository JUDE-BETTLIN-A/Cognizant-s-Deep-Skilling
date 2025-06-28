import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "BookID: " + bookId + ", Title: \"" + title + "\", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear search: finds all books whose titles contain the search string (case-insensitive)
    public static void linearSearch(Book[] books, String searchTitle) {
        System.out.println("Linear search results for \"" + searchTitle + "\":");
        boolean found = false;
        String lowerSearch = searchTitle.toLowerCase();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(lowerSearch)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found.");
        }
    }

    // Binary search: finds books with exact title match (case-insensitive), assumes books sorted by title
    public static void binarySearch(Book[] books, String searchTitle) {
        System.out.println("Binary search results for \"" + searchTitle + "\":");
        int left = 0, right = books.length - 1;
        String searchLower = searchTitle.toLowerCase();
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midTitle = books[mid].title.toLowerCase();
            int cmp = midTitle.compareTo(searchLower);

            if (cmp == 0) {
                found = true;
                System.out.println(books[mid]);
                int i = mid - 1;
                while (i >= 0 && books[i].title.equalsIgnoreCase(searchTitle)) {
                    System.out.println(books[i]);
                    i--;
                }
                i = mid + 1;
                while (i < books.length && books[i].title.equalsIgnoreCase(searchTitle)) {
                    System.out.println(books[i]);
                    i++;
                }
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Java Programming", "Alice"),
                new Book(2, "Data Structures", "Bob"),
                new Book(3, "Algorithms", "Carol"),
                new Book(4, "Effective Java", "Joshua"),
                new Book(5, "Java Programming", "David")
        };

        linearSearch(books, "Java");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\nSorted books:");
        for (Book b : books) System.out.println(b);

        System.out.println();
        binarySearch(books, "Java Programming");
        binarySearch(books, "Effective Java");
        binarySearch(books, "Python Basics");
    }
}
