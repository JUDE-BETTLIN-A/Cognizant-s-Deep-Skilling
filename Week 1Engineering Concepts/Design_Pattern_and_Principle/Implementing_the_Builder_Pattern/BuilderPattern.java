// Step 2: Define the Product Class
class Computer {
    // Required and optional attributes
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    // Step 4: Private constructor that accepts Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // Display configuration
    public void showConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "None"));
        System.out.println("OS: " + (operatingSystem != null ? operatingSystem : "None"));
    }

    // Step 3: Static nested Builder class
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String os) {
            this.operatingSystem = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Step 5: Test Class
public class BuilderPattern {
    public static void main(String[] args) {
        // Basic computer
        Computer basicComputer = new Computer.Builder()
            .setCPU("Intel i3")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .build();

        basicComputer.showConfig();

        System.out.println("----------------------------");

        // High-end gaming computer
        Computer gamingComputer = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4090")
            .setOperatingSystem("Windows 11 Pro")
            .build();

        gamingComputer.showConfig();
    }
}
