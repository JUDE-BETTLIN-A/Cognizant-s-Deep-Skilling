import java.util.*;

//Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void setPrice(double price); 
}

//Observer Interface
interface Observer {
    void update(double price);
}

//Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println(o.getClass().getSimpleName() + " registered.");
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println(o.getClass().getSimpleName() + " removed.");
    }

    public void notifyObservers() {
        System.out.println("Notifying observers about price change...");
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }

    public void setPrice(double price) {
        System.out.println("\nStock price updated to: " + price);
        this.stockPrice = price;
        notifyObservers();
    }
}

//Concrete Observers
class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("MobileApp received stock price update: $" + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("WebApp received stock price update: $" + price);
    }
}

//Test Class
public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(100.50);
        stockMarket.setPrice(102.75);

        stockMarket.removeObserver(mobileApp);

        stockMarket.setPrice(99.30);
    }
}
