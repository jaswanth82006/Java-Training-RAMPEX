# Online Food Ordering System

A robust console-based **Online Food Ordering System** built in Java. This project demonstrates core Object-Oriented Programming (OOP) principles while implementing a streamlined flow for managing users, ordering food, applying discounts, and processing payments. 

## 🚀 Features

* **Menu Management:** Order from an inventory of items while verifying item stock availability.
* **Customer Dashboard:** Manage customer profiles containing order delivery details and contact information.
* **Shopping Cart & Checkout:** Calculate order totals, track order statuses, and generate receipts.
* **Promotional Discounts:** Use promotional strings (e.g., `WELCOME10`) to calculate cart discounts.
* **Loyalty Points System:** Earn loyalty points with every dollar spent on successful orders. 
* **Dynamic Payment Processing:** Pay utilizing various methods like Credit Cards or Digital Wallets using a shared interface.
* **Custom Error Handling:** Input validation and graceful failures through custom exceptions (e.g., attempting checkout on an empty cart).

## 🧩 Core OOP Concepts Demonstrated

* **Encapsulation:** Class variables (like `loyaltyPoints` in `Customer`, or `items` in `Order`) are kept private and managed securely via getter and setter methods.
* **Inheritance:** Extends generalized classes (e.g., the `Customer` class inherits properties from the `User` class).
* **Polymorphism:** Utilizing overridden methods (e.g., `displayDashboard()` in `Customer` class) and dynamic method dispatch in Payment processors.
* **Abstraction:** The `Payment` interface obscures implementation details underneath specialized gateway formats (`CardPayment`, `UpiPayment`).

## 📁 Project Structure

```text
com/foodorder/
├── exceptions/
│   └── InvalidOrderException.java       # Custom exception definition
├── main/
│   └── FoodOrderingSystem.java          # Main application execution flow
├── models/
│   ├── Customer.java                    # Customer logic (extends User)
│   ├── MenuItem.java                    # Struct for available food menu
│   ├── Order.java                       # Cart and Order calculations
│   └── User.java                        # Base identity class
└── payments/
    ├── CardPayment.java                 # Payment Interface implementation
    ├── UpiPayment.java                  # Payment Interface implementation
    └── Payment.java                     # Payment abstractions
```

## ⚙️ Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher installed on your system.
* Windows OS to utilize the embedded build script.

### Running the Application (Windows)

A batch script (`run.cmd`) has been provided to simplify building and executing the application.
1. Download or clone this repository to your local machine.
2. Open the project folder in your command prompt or simply double click the file.
3. Execute the batch runner:

```cmd
.\run.cmd
```

The script will:
* Check for and build the `bin` directory for compiled artifacts.
* Compile all sub-module `.java` packages dynamically.
* Execute the `FoodOrderingSystem` Main Class.

## 📝 Example Output

```
=== Welcome to the Online Food Ordering System ===

--- Customer Dashboard ---
Welcome, Jaswanth K!
Email: jaswanth@example.com
Delivery Address: 123 Main St, Chennai.
Loyalty Points: 0

--- Order Summary ---
--- Receipt for Order #1001 ---
Customer: Jaswanth K
- Classic Burger: $8.99
- French Fries: $3.49
- Cola: $1.99
Subtotal: $14.47
Total Amount: $14.47
Status: PENDING
---------------------------------

--- Applying Coupon ---
Applied 10% discount from coupon: WELCOME10
...
Total Amount: $13.02

--- Checkout ---
Processing Card payment for: $13.02
Card Holder: Jaswanth K | Last 4 digits: 3456
Payment Successful!
Order Status updated to: PREPARING
You earned 13 loyalty points! Total points: 13
```
