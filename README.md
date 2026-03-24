# Billing-Management-Java
To design and implement a Billing Management System using Java.  The system allows the user to add products, calculate total bill amount and display  billing details.  This project demonstrates important Object-Oriented Programming concepts such as:  • Classes and Objects  • Exception Handling  • Generics  • Collection Framework (ArrayList)  • User
🧾 Billing Management System using Java

A simple yet powerful Billing Management System developed using Java, demonstrating key concepts like Generics, Exception Handling, and Object-Oriented Programming (OOP).

🚀 Features
🛒 Add product details (ID, Name, Price, Quantity)
⚠️ Custom Exception Handling for invalid price
🧮 Automatic total calculation per product
📊 Display complete bill with grand total
🔁 Menu-driven program
📦 Generic Store class for flexible data handling
🛠️ Technologies Used
Java
OOP Concepts (Classes, Objects)
Generics
Exception Handling
Collections (ArrayList)
📌 How It Works
User selects options from menu
Adds product details
System validates input using custom exception
Products are stored using a generic class
Bill is generated with total cost
Program runs until user exits
▶️ How to Run
javac BillingManagement.java
java BillingManagement
💻 Source Code
import java.util.*; 

// Custom Exception 
class InvalidPriceException extends Exception { 
    public InvalidPriceException(String msg) { 
        super(msg); 
    } 
} 

// Product Class 
class Product { 
    int id; 
    String name; 
    double price; 
    int quantity; 

    Product(int id, String name, double price, int quantity) throws InvalidPriceException { 
        if (price < 0) { 
            throw new InvalidPriceException("Price cannot be negative!"); 
        } 
        this.id = id; 
        this.name = name; 
        this.price = price; 
        this.quantity = quantity; 
    } 

    double getTotal() { 
        return price * quantity; 
    } 

    void display() { 
        System.out.println(id + " | " + name + " | Price: " + price + 
        " | Qty: " + quantity + " | Total: " + getTotal()); 
    } 
} 

// Generic Store Class 
class Store<T> { 
    private List<T> items = new ArrayList<>(); 

    void addItem(T item) { 
        items.add(item); 
    } 

    List<T> getItems() { 
        return items; 
    } 
} 

public class BillingManagement { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 
        Store<Product> store = new Store<>(); 

        while (true) { 

            System.out.println("\n===== Billing Management ====="); 
            System.out.println("1. Add Product"); 
            System.out.println("2. View Bill"); 
            System.out.println("3. Exit"); 

            System.out.print("Enter choice: "); 
            int ch = sc.nextInt(); 

            switch (ch) { 

                case 1: 
                    try { 
                        System.out.print("Enter Product ID: "); 
                        int id = sc.nextInt(); 

                        System.out.print("Enter Product Name: "); 
                        String name = sc.next(); 

                        System.out.print("Enter Price: "); 
                        double price = sc.nextDouble(); 

                        System.out.print("Enter Quantity: "); 
                        int qty = sc.nextInt(); 

                        Product p = new Product(id, name, price, qty); 
                        store.addItem(p); 

                        System.out.println("Product added to bill."); 

                    } catch (InvalidPriceException e) { 
                        System.out.println("Error: " + e.getMessage()); 
                    } catch (Exception e) { 
                        System.out.println("Invalid input!"); 
                        sc.nextLine(); 
                    } 
                    break; 

                case 2: 
                    double grandTotal = 0; 

                    System.out.println("\n------ Bill Details ------"); 

                    for (Product p : store.getItems()) { 
                        p.display(); 
                        grandTotal += p.getTotal(); 
                    } 

                    System.out.println("--------------------------"); 
                    System.out.println("Grand Total: " + grandTotal); 
                    break; 

                case 3: 
                    System.out.println("Exiting Billing System..."); 
                    sc.close(); 
                    return; 

                default: 
                    System.out.println("Invalid Choice!"); 
            } 
        } 
    } 
}
<img width="1916" height="801" alt="Screenshot 2026-03-12 144101" src="https://github.com/user-attachments/assets/d257df28-9cc8-45a4-8275-53caf87e7849" />
<img width="1913" height="807" alt="Screenshot 2026-03-12 144123" src="https://github.com/user-attachments/assets/ab21a560-9637-4f4f-a13b-d22871da265c" />
<img width="1917" height="805" alt="Screenshot 2026-03-12 144146" src="https://github.com/user-attachments/assets/28e15400-6daf-4189-9301-31930d8ab59b" />

📊 Sample Output
===== Billing Management =====
1. Add Product
2. View Bill
3. Exit

Enter choice: 1
Enter Product ID: 101
Enter Product Name: Pen
Enter Price: 10
Enter Quantity: 5

------ Bill Details ------
101 | Pen | Price: 10.0 | Qty: 5 | Total: 50.0
--------------------------
Grand Total: 50.0
🎯 Learning Outcomes
Understanding Generics in Java
Implementing Custom Exceptions
Working with Collections (ArrayList)
Designing menu-driven applications
Applying OOP principles in real-world problems
🙌 Conclusion

This project demonstrates how Java can be used to build a simple billing system with structured design, proper error handling, and reusable components using generics.
