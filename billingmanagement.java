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