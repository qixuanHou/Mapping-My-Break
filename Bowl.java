/**
 * @author Qixuan Hou
 * @version 3/13/2014
 */
import java.text.NumberFormat;
import java.util.Locale;
public class Bowl extends GroceryItem {
    private final String scheme = "";

    /**
     * Creates a DryGood with the given name and price
     *
     * @param name  the name of this DryGood
     * @param price the price of this DryGood
     */
    public Bowl(String name, double price) {
        super(name, price);
    }

    /**
     * @return  the String represents the name
     * of the product, the price and the pricing scheme
     */
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        return getName() + " @ " + (us.format(getPrice()));
    }

    /**
     * getter for Quantity Query
     * @return  the String prompts the user for the
     * appropriate unit amount of each product
     */
    public String getQuantityQuery() {
        return "How many "  + getName() + " would you like? ";
    }

    /**
     * getter for cost
     * @param quantity the quantity of ProduceItem
     * @return  the String prompts the user for the
     * appropriate unit amount of each product
     */
    public double getCostOf(int quantity) {
        return quantity * getPrice();
    }
}



