
interface Sellable {
    void displayItemDetails();
    double getPrice();
}

abstract class Product implements Sellable {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    abstract double calculateDiscount();

    @Override
    public double getPrice() {
        return price - calculateDiscount();
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item: " + name);
        System.out.println("Category: " + category);
        System.out.println("Base Price: $" + price);
        System.out.println("Discount: $" + calculateDiscount());
        System.out.println("Final Price: $" + getPrice());
        System.out.println("-----------------------------------");
    }
}

class ElectronicItem extends Product {
    int warrantyYears;

    ElectronicItem(String name, double price, int warrantyYears) {
        super(name, "Electronics", price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public void displayItemDetails() {
        super.displayItemDetails();
        System.out.println("Warranty: " + warrantyYears + " years");
        System.out.println("-----------------------------------");
    }
}

class ClothingItem extends Product {
    String size;

    ClothingItem(String name, double price, String size) {
        super(name, "Clothing", price);
        this.size = size;
    }

    @Override
    double calculateDiscount() {
        return price * 0.20;
    }

    @Override
    public void displayItemDetails() {
        super.displayItemDetails();
        System.out.println("Size: " + size);
        System.out.println("-----------------------------------");
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ElectronicItem laptop = new ElectronicItem("Dell Laptop", 60000, 2);
        ClothingItem tshirt = new ClothingItem("Polo T-Shirt", 1500, "L");

        Sellable[] items = {laptop, tshirt};

        for (Sellable item : items) {
            item.displayItemDetails();
        }
    }
}
