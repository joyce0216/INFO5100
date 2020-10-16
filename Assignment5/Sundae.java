package Assignment5;

public class Sundae extends IceCream {
    String toppingName;
    int toppingPrice;
    public Sundae(String name, int price, String toppingName, int toppingPrice) {
        super(name, price);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    @Override
    public int getCost() {
        int cost = super.getCost() + toppingPrice;
        return cost;
    }

    public String toString() {
        return String.format("%s with %n%s %s", DessertShoppe.truncateItemName(name), toppingName,
                DessertShoppe.cents2dollarsAndCents(getCost()));
    }
}
