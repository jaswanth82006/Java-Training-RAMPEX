class User {
    String name;
    String phone;
    String location;

    User(String name, String phone, String location) {
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Phone: " + phone + ", Location: " + location);
    }
}

class RideUser extends User {
    String vehicleType;

    RideUser(String name, String phone, String location, String vehicleType) {
        super(name, phone, location);
        this.vehicleType = vehicleType;
    }

    void displayRide() {
        displayInfo();
        System.out.println("Vehicle Type: " + vehicleType);
    }
}
class FoodUser extends User {
    String favFood;

    FoodUser(String name, String phone, String location, String favFood) {
        super(name, phone, location);
        this.favFood = favFood;
    }

    void displayFood() {
        displayInfo();
        System.out.println("Favorite Food: " + favFood);
    }
}

class ParcelUser extends User {
    double parcelWeight;

    ParcelUser(String name, String phone, String location, double parcelWeight) {
        super(name, phone, location);
        this.parcelWeight = parcelWeight;
    }

    void displayParcel() {
        displayInfo();
        System.out.println("Parcel Weight: " + parcelWeight + " kg");
    }
}

public class app {
    public static void main(String[] args) {

        RideUser r = new RideUser("Luna", "12345", "Chennai", "Bike");
        FoodUser f = new FoodUser("Kali", "67890", "Delhi", "Pizza");
        ParcelUser p = new ParcelUser("Postgres", "11111", "Mumbai", 2.5);

        r.displayRide();
        System.out.println();

        f.displayFood();
        System.out.println();

        p.displayParcel();
    }
}
