//Subject Interface
interface Image {
    void display();
}

//Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

//Proxy Class
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); 
        } else {
            System.out.println("Using cached image: " + filename);
        }
        realImage.display();
    }
}

// Step 5: Test Class
public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        image1.display();

        System.out.println("------------------");

        image1.display();

        System.out.println("------------------");

        image2.display();
    }
}
