package Assignment5;

import java.util.Arrays;
import java.util.List;

public class DessertShoppe {
    public static final double TAX_RATE = 0.065;
    public static final int ITEM_NAME_LIMIT = 16;
    public static final String STORE_NAME = "M & M Dessert Shoppe";

    public static String cents2dollarsAndCents(int cents) {
        double ans = ((double) cents / 100);
        return Double.toString(ans);
    }

    /**
     * Truncate an item name if it exceeds the limit
     * @param itemName name of dessert
     * @return truncated item name
     */
    public static String truncateItemName(String itemName) {
        return itemName.length() > ITEM_NAME_LIMIT
                ? itemName.substring(0, ITEM_NAME_LIMIT - 1) + "."
                : itemName;

    }
}
