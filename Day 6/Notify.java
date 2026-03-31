// Parent class (Base)
class NotificationBase {
    void send(String message) {
        System.out.println("Sending generic notification: " + message);
    }
}

// Child class - Email (Overriding)
class EmailNotification extends NotificationBase {
    @Override
    void send(String message) {
        System.out.println("Sending EMAIL notification: " + message);
    }
}

// Child class - SMS (Overriding)
class SMSNotification extends NotificationBase {
    @Override
    void send(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

// Class demonstrating Overloading
class Notification {

    // Method 1
    void sendNotification(String message) {
        System.out.println("General Notification: " + message);
    }

    // Method 2 (Email)
    void sendNotification(String message, String email) {
        System.out.println("EMAIL to " + email + ": " + message);
    }

    // Method 3 (SMS)
    void sendNotification(String message, long phoneNumber) {
        System.out.println("SMS to " + phoneNumber + ": " + message);
    }
}

// Main class
public class Notify {
    public static void main(String[] args) {

        // 🔹 Overloading (Compile-time Polymorphism)
        Notification n = new Notification();
        n.sendNotification("Welcome User");
        n.sendNotification("Welcome via Email", "user@gmail.com");
        n.sendNotification("Welcome via SMS", 9876543210L);

        System.out.println();

        // 🔹 Overriding (Runtime Polymorphism)
        NotificationBase obj;

        obj = new EmailNotification(); // Upcasting
        obj.send("Hello Email User");

        obj = new SMSNotification(); // Upcasting
        obj.send("Hello SMS User");
    }
}
