package Assignment5;

public class IceCream extends DessertItem {

    int price;

    public IceCream(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getCost() {
        return price;
    }

    public String toString() {
        return String.format("%s %s", DessertShoppe.truncateItemName(name), DessertShoppe.cents2dollarsAndCents(price));
    }
}