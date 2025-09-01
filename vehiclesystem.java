abstract class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    abstract void start();

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

interface FuelEfficient {
    double calculateMileage();
}

class Car extends Vehicle implements FuelEfficient {
    int fuelConsumed;
    int distance;

    Car(String brand, int speed, int fuelConsumed, int distance) {
        super(brand, speed);
        this.fuelConsumed = fuelConsumed;
        this.distance = distance;
    }

    @Override
    void start() {
        System.out.println(brand + " Car is starting...");
    }

    @Override
    public double calculateMileage() {
        return (double) distance / fuelConsumed;
    }
}

class Bike extends Vehicle implements FuelEfficient {
    int fuelConsumed;
    int distance;

    Bike(String brand, int speed, int fuelConsumed, int distance) {
        super(brand, speed);
        this.fuelConsumed = fuelConsumed;
        this.distance = distance;
    }

    @Override
    void start() {
        System.out.println(brand + " Bike is starting...");
    }

    @Override
    public double calculateMileage() {
        return (double) distance / fuelConsumed;
    }
}


public class vehiclesystem {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 120, 10, 150);
        Bike bike = new Bike("Honda", 80, 3, 120);

        car.start();
        car.displayInfo();
        System.out.println("Car Mileage: " + car.calculateMileage() + " km/l");
        System.out.println();

        bike.start();
        bike.displayInfo();
        System.out.println("Bike Mileage: " + bike.calculateMileage() + " km/l");
    }
}
