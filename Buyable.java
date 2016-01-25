/**
 * Makes a GroceryItem "listable" by the GroceryBot. DO NOT EDIT!
 *
 * @author Joseph Rossi
 * @version 1.0 2/21/2014
 */
public interface Buyable {

    /**
     * Calculates the cost of this GroceryItem at the given quantity
     *
     * @param quantity  the quantity
     * @return  the cost
     */
    double getCostOf(int quantity);

    /**
     * Changes the String representation of this GroceryItem
     *
     * @return  the String representation of this GroceryItem
     */
    String toString();

    /**
     * Gives a String asking for a quantity in the GroceryItem's native units
     *
     * @return  the quantity query String
     */
    String getQuantityQuery();
}
