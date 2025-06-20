class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", TotalPrice: ₹" + totalPrice;
    }
}

public class SortOrders {

    // bubble Sort by totalPrice
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    // quick Sort by totalPrice
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void displayOrders(Order[] orders, String method) {
        System.out.println("\nSorted Orders using " + method + ":");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] orders1 = {
                new Order(1, "Alice", 4500.75),
                new Order(2, "Bob", 1200.00),
                new Order(3, "Charlie", 8500.25),
                new Order(4, "David", 3000.50),
                new Order(5, "Eve", 6000.00)
        };

        Order[] orders2 = orders1.clone(); // duplicate for quick sort

        bubbleSort(orders1);
        displayOrders(orders1, "Bubble Sort");

        quickSort(orders2, 0, orders2.length - 1);
        displayOrders(orders2, "Quick Sort");
    }
}
