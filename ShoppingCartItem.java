/**
 * @author Qixuan Hou
 * @version 3/13/2014
 */
import java.text.NumberFormat;
import java.util.Locale;
public class ShoppingCartItem {
    private Buyable item;
    private int quantity;

    /**
     * Creates a ShoppingCartItem with the given Buyable item
     *
     * @param anItem of Buyable type
     */
    public ShoppingCartItem(Buyable anItem) {
        item = anItem;
    }

    /**
     * Setter for the quantity field
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int aQuantity) {
        quantity = aQuantity;
    }

    /**
     * Overrides Object's toString method.
     *
     * @return  the String describes the buyable it holds
    */
    @Override
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        String aString = ((GroceryItem) item).toString() + "\r\n       x"
                            + quantity + " "
                            + " = " + (us.format(calculateCost()));
        return aString;
    }

    /**
     * Getter for item field and then cast it to GroceryItem
     *
     * @return  the item
     */
    public GroceryItem getItem() {
        return ((GroceryItem) item);
    }

    /**
     * Getter for quantity field
     *
     * @return  the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the cost of this item at the given quantity
     *
     * @return  the cost
     */
    public double calculateCost() {
        return ((GroceryItem) item).getCostOf(quantity);
    }
    /**
     * Overrides hashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Overrides Object's equals method. Two ShoppingCartItem(s) are the same if
     * their name and quantity are the same.
     *
     * @param o an Object we are testing against "this" for equality
     * @return  true if o and "this" are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof ShoppingCartItem)) {
            return false;
        }
        ShoppingCartItem g = (ShoppingCartItem) o;
        return (this.getItem().getName()).equals((g.getItem().getName()))
            && (this.getQuantity() == g.getQuantity());
    }
}

