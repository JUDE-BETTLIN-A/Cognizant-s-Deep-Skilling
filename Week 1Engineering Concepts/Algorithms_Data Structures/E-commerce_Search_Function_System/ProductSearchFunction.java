import java.util.Arrays;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Category: " + category;
    }
}

public class ProductSearchFunction {

    // binary search
    public static Product binarySearchById(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (products[mid].productId == targetId) {
                System.out.println("Total comparisons made: " + comparisons);
                return products[mid];
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Total comparisons made: " + comparisons);
        return null;
    }

    public static void displayAllProducts(Product[] products) {
        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(203, "Shoes", "Footwear"),
                new Product(150, "Keyboard", "Accessories"),
                new Product(120, "Phone", "Electronics"),
                new Product(180, "Monitor", "Electronics"),
                new Product(110, "Tablet", "Electronics")
        };

        // sort the array by productId for binary search
        Arrays.sort(products, (a, b) -> a.productId - b.productId);

        Scanner scanner = new Scanner(System.in);

        displayAllProducts(products);

        while (true) {
            System.out.print("Enter Product ID to search (or -1 to exit): ");
            int targetId = scanner.nextInt();

            if (targetId == -1) {
                System.out.println("Exiting...");
                break;
            }

            Product found = binarySearchById(products, targetId);
            if (found != null) {
                System.out.println("Product Found: " + found);
            } else {
                System.out.println("Product Not Found.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
