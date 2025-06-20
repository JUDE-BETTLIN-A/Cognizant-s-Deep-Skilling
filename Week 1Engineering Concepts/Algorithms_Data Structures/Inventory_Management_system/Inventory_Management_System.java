import java.util.HashMap;
import java.util.Scanner;

// creating product variable
class Product {
    int productid;
    String productname;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productid = productId;
        this.productname = productName;
        this.quantity = quantity;
        this.price = price;
    }

    //to print product detailes
    public String toString() {
        return "Product [ID=" + productid + ", Name=" + productname +
                ", Quantity=" + quantity + ", Price=" + price + "]";
    }
}

// InventoryManager class
class InventoryManager {

    //creating a hashmap for the beter time and space complexity

    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productid, product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product prod = inventory.get(productId);

        if (prod != null) {
            prod.quantity = quantity;
            prod.price = price;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProduct(int productId) {
        Product prod = inventory.get(productId);
        if (prod != null) {
            System.out.println(prod);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }
}


public class Inventory_Management_System {
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    manager.addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.print("Enter new Price: ");
                    double newPrice = sc.nextDouble();
                    manager.updateProduct(updateId, newQty, newPrice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteProduct(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Product ID to display: ");
                    int displayId = sc.nextInt();

                    manager.displayProduct(displayId);
                    break;

                case 5:
                    manager.displayAllProducts();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}