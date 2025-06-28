//define Singleton Class
class Logger {
    //private static instance of Logger
    private static Logger instance;

    //private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    //public method to return the same instance every time
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    //example method to simulate logging
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

//test Class
public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances found. Singleton pattern not implemented correctly.");
        }
    }
}
