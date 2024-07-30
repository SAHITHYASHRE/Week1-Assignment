//Exercise 1: Inventory Management System
//Define the Product Class:

public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
//Data Structure Used Hashmap
import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Method to add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to delete a product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to retrieve a product
    public Product getProduct(int productId) {
        return inventory.get(productId);
    }
}

//Time Complexity Analysis

//Add Operation: O(1) 
//Update Operation: O(1) 
//Delete Operation: O(1) 
//Search Operation: O(1) 

//Exercise 2: E-commerce Platform Search Function

//Create a class Product
public class Product {
    private int productId;
    private String productName;
    private String category;

    // Constructor and getters/setters
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
}
//Linear Search
public Product linearSearch(Product[] products, String searchTerm) {
    for (Product product : products) {
        if (product.getProductName().equals(searchTerm)) {
            return product;
        }
    }
    return null; // Not found
}
//Binary Search
public Product binarySearch(Product[] products, String searchTerm) {
    int left = 0, right = products.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (products[mid].getProductName().compareTo(searchTerm) == 0) {
            return products[mid];
        } else if (products[mid].getProductName().compareTo(searchTerm) < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return null; // Not found
}
}
//Time complexity analysis:
//Linear Search Time Complexity: O(n) - Scans each element.
//Binary Search Time Complexity: O(log n)

//Exercise 3: Sorting Customer Orders
//Create a class Order
public class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    // Constructor and getters/setters
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() { return totalPrice; }
}
//Bubble Sort
public void bubbleSort(Order[] orders) {
    int n = orders.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                Order temp = orders[j];
                orders[j] = orders[j + 1];
                orders[j + 1] = temp;
            }
        }
    }
}
//Quick Sort
public void quickSort(Order[] orders, int low, int high) {
    if (low < high) {
        int pi = partition(orders, low, high);
        quickSort(orders, low, pi - 1);
        quickSort(orders, pi + 1, high);
    }
}

private int partition(Order[] orders, int low, int high) {
    double pivot = orders[high].getTotalPrice();
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (orders[j].getTotalPrice() <= pivot) {
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
//Time complexity analysis:
//Bubble Sort Time Complexity: O(n^2)
//Quick Sort Time Complexity: O(n log n)

//Exercise 4: Employee Management System
//Create a class Employee
public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    // Constructor and getters/setters
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
}
//array operations
public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Not found
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getName());
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            size--;
        }
    }
}
//Time Analysis:

//Add Operation Time Complexity: O(1)
//Search Operation Time Complexity: O(n)
//Traverse Operation Time Complexity: O(n) 
//Delete Operation Time Complexity: O(n) 
//Exercise 5: Task Management System
//Create a class Task
public class Task {
    private int taskId;
    private String taskName;
    private String status;

    // Constructor and getters/setters
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }
}

//Singly Linked List
public class SinglyLinkedList {
    private Node head;

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Not found
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task.getTaskName());
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        Node current = head, prev = null;
        while (current != null && current.task.getTaskId() != taskId) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                head = current.next;
            }
        }
    }
}
//Time Analysis:

//Add Operation Time Complexity: O(1) 
//Search Operation Time Complexity: O(n) 
//Traverse Operation Time Complexity: O(n) 
//Delete Operation Time Complexity: O(n) 

//Exercise 6: Library Management System
//Create a class Book
public class Book {
    private int bookId;
    private String title;
    private String author;

    // Constructor and getters/setters
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
}
//Linear search
public Book linearSearch(Book[] books, String title) {
    for (Book book : books) {
        if (book.getTitle().equals(title)) {
            return book;
        }
    }
    return null; // Not found
}
//Binary Search
public Book binarySearch(Book[] books, String title) {
    int left = 0, right = books.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (books[mid].getTitle().compareTo(title) == 0) {
            return books[mid];
        } else if (books[mid].getTitle().compareTo(title) < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return null; // Not found
}
//Time analysis
Linear Search Time Complexity: O(n)
Binary Search Time Complexity: O(log n)
  //Exercise 7: Financial Forecasting
  //Create a method to calculate future value recursively
  public double forecastFutureValue(double[] pastValues, int monthsAhead) {
    // Assuming a simple growth rate based on average past growth
    double growthRate = calculateAverageGrowth(pastValues);
    return calculateFutureValue(pastValues[pastValues.length - 1], growthRate, monthsAhead);
}

private double calculateAverageGrowth(double[] values) {
    double totalGrowth = 0;
    for (int i = 1; i < values.length; i++) {
        totalGrowth += (values[i] - values[i - 1]) / values[i - 1];
    }
    return totalGrowth / (values.length - 1);
}
//Time Complexity: O(n) 
