package Assignment5;

import java.util.ArrayList;
import java.util.List;

import static Assignment5.DessertShoppe.TAX_RATE;

public class Checkout {
    ArrayList<DessertItem> itemList = new ArrayList<>();

    public int numberOfItems() {
        return itemList.size();
    }

    public void enterItem(DessertItem item) {
        itemList.add(item);
    }

    public void clear() {
        itemList.clear();
    }

    public int totalCost() {
        int sumCost = 0;
        for(DessertItem items: itemList) {
            sumCost = sumCost + items.getCost();
        }
        return sumCost;
    }

    public int totalTax() {
        int totalTax = 0;
        for(DessertItem items: itemList) {
            totalTax = totalTax + (int)(items.getCost() * TAX_RATE);
        }

        return totalTax;
    }

    public String toString() {
        List<String> receiptItems = new ArrayList<>();
        receiptItems.add("Number of items: " + numberOfItems());
        receiptItems.add("Total cost: " + totalCost());
        receiptItems.add("Total tax: " + totalTax());
        receiptItems.add("Cost + Tax: " + (totalCost() + totalTax()));
        receiptItems.add(DessertShoppe.STORE_NAME);
        receiptItems.add("----------------------");
        itemList.forEach(item -> receiptItems.add(item.toString()));
        receiptItems.add("Tax: " + DessertShoppe.cents2dollarsAndCents(totalTax()));
        receiptItems.add("Total Cost: " + DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()));

        return String.join("\n", receiptItems);
    }
}
