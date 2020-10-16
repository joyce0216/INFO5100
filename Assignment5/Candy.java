package Assignment5;

import static Assignment5.DessertShoppe.truncateItemName;

public class Candy extends DessertItem {
    double weight;
    int pricePerPound;
    public Candy(String name, double weight, int pricePerPound){
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }
    @Override
    public int getCost() {
        int cost = (int) (weight * pricePerPound);
        return cost;
    }

    public String toString() {
        return String.format("%.2f @ %s/lb. %n%s %s", weight, DessertShoppe.cents2dollarsAndCents(pricePerPound),
                DessertShoppe.truncateItemName(name), DessertShoppe.cents2dollarsAndCents(getCost()));

    }


}
