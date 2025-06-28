//Repository Interface
interface CustomerRepository {
    Customer findCustomerById(String id);
}

//Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        // Simulated database lookup
        return new Customer(id, "Alice Johnson", "alice@example.com");
    }
}

//Supporting Model Class
class Customer {
    private String id;
    private String name;
    private String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void displayInfo() {
        System.out.println("Customer Info:");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}

//Service Class
class CustomerService {
    private CustomerRepository repository;

    //Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void findAndDisplayCustomer(String id) {
        Customer customer = repository.findCustomerById(id);
        customer.displayInfo();
    }
}

//Test Class
public class DependencyInjection {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.findAndDisplayCustomer("C101");
    }
}
