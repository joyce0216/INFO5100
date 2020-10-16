package Assignment5;

public class Cookie extends DessertItem {
    int number;
    int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen){
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getCost() {
        return (int) (pricePerDozen * number / 12);
    }

    public String toString() {
        return String.format("%d @ %s /dz. %n%s %s", number, DessertShoppe.cents2dollarsAndCents(pricePerDozen),
                DessertShoppe.truncateItemName(name), DessertShoppe.cents2dollarsAndCents(getCost()));
    }
}
