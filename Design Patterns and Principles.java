//Exercise 1: Implementing the Singleton Pattern
//Create a new Java project named SingletonPatternExample.
//Define the Logger class:
public class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
//Test the Singleton Implementation
public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Logger 1 instance");
        logger2.log("Logger 2 instance");

        System.out.println("Are both instances the same? " + (logger1 == logger2));
    }
}
//Exercise 2: Implementing the Factory Method Pattern
//Create a new Java project named FactoryMethodPatternExample.
//Define Document Interfaces
public interface Document {
    void open();
}

public class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document.");
    }
}

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document.");
    }
}

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document.");
    }
}
//Implement Factory Method
public abstract class DocumentFactory {
    public abstract Document createDocument();
}

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

public class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

//Test the Factory Method Implementation
public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
//Exercise 3: Implementing the Builder Pattern
//Create a new Java project named BuilderPatternExample.
//Define Computer class with a static nested Builder class
public class Computer {
    private String CPU;
    private String RAM;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + "]";
    }
}
//Test the Builder Implementation
public class BuilderTest {
    public static void main(String[] args) {
        Computer comp1 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        Computer comp2 = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("8GB")
                .setStorage("1TB HDD")
                .build();

        System.out.println(comp1);
        System.out.println(comp2);
    }
}
//Exercise 4: Implementing the Adapter Pattern
//Create a new Java project named AdapterPatternExample.
//Define Target Interface
public interface PaymentProcessor {
    void processPayment(double amount);
}
//Implement Adaptee Classes
public class PayPal {
    public void makePayment(double amount) {
        System.out.println("Paying " + amount + " using PayPal.");
    }
}

public class Stripe {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using Stripe.");
    }
}
//Implement Adapter Classes
public class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

public class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}
//Test the Adapter Implementation
public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        payPalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(200.0);
    }
}
//Exercise 5: Implementing the Decorator Pattern
//Create a new Java project named DecoratorPatternExample.
//Define Component Interface
public interface Notifier {
    void send(String message);
}
//Implement Concrete Component
public class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
//Implement Decorator Classes
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}
//Test the Decorator Implementation
public class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Hello, World!");
    }
}

//Exercise 6: Implementing the Proxy Pattern
//Create a new Java project named ProxyPatternExample.
//Define Subject Interface:
public interface Image {
    void display();
}
//Implement Real Subject Class
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}
//Implement Proxy Class
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
//Test the Proxy Implementation
public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        image.display();  // Image will be loaded from disk and displayed
        image.display();  // Image will be displayed without loading from disk
    }
}
//Exercise 7: Implementing the Observer Pattern
//Create a new Java project named ObserverPatternExample.
//Define Subject Interface:
import java.util.ArrayList;
import java.util.List;

public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
//Implement Concrete Subject
public class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}
//Define Observer Interface
public interface Observer {
    void update(double stockPrice);
}

//Implement Concrete Observers:
public class MobileApp implements Observer {
    public void update(double stockPrice) {
        System.out.println("MobileApp: Stock price updated to " + stockPrice);
    }
}

public class WebApp implements Observer {
    public void update(double stockPrice) {
        System.out.println("WebApp: Stock price updated to " + stockPrice);
    }
}
//Test the Observer Implementation
public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(200.0);
    }
}
//Exercise 8: Implementing the Strategy Pattern
//Create a new Java project named StrategyPatternExample.
//Define Strategy Interface
public interface PaymentStrategy {
    void pay(double amount);
}
//Implement Concrete Strategies
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
    }
}

public class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal.");
    }
}
//Implement Context Class
public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}
//Test the Strategy Implementation
public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(150.0);

        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(200.0);
    }
}
//Exercise 9: Implementing the Command Pattern
//Create a new Java project named CommandPatternExample.
//Define Command Interface
public interface Command {
    void execute();
}
//Implement Concrete Commands
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
//Implement Invoker Class

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
//Implement Receiver Class
public class Light {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}
//Test the Command Implementation
public class CommandTest {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
//Exercise 10: Implementing the MVC Pattern
//Create a new Java project named MVCPatternExample.
//Define Model Class
public class Student {
    private String name;
    private String id;
    private String grade;

    // Constructors, getters, setters
    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
//Define View Class
public class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}
//Define Controller Class
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public String getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
//Test the MVC Implementation
public class MVCTest {
    public static void main(String[] args) {
        Student model = new Student("John Doe", "12345", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B+");
        controller.updateView();
    }
}
//Exercise 11: Implementing Dependency Injection
//Create a new Java project named DependencyInjectionExample.
//Define Repository Interface:
public interface CustomerRepository {
    Customer findCustomerById(String id);
}
//Implement Concrete Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        return new Customer(id, "CustomerName");
    }
}
//Define Service Class
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}
//Test the Dependency Injection Implementation
public class DIExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        Customer customer = service.getCustomerById("12345");
        System.out.println("Customer: " + customer.getName());
    }
}
//Customer class definition (used in both repository and service):
public class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
