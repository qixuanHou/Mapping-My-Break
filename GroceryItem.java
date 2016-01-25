/**
 * A GroceryItem is an item as stocked on the grocery store shelves. It knows
 * its name and price, but nothing about quantities. Once a GroceryItem has been
 * added to the cart, it becomes a ShoppingCartItem with a specific quantity.
 *
 * @author Joseph Rossi
 * @version 1.0 2/21/2014
 */
public abstract class GroceryItem implements Buyable {

    private String name;
    private double price;

    /**
     * Creates a GroceryItem with the given name and price
     *
     * @param name  the name of this GroceryItem
     * @param price the price of this GroceryItem
     */
    public GroceryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for name field
     *
     * @return  the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the price field
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for the price field
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Overrides hashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Overrides Object's equals method. Two GroceryItem(s) are the same if
     * their name and price are the same.
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
        if (!(o instanceof GroceryItem)) {
            return false;
        }
        GroceryItem g = (GroceryItem) o;
        return this.getName().equals(g.getName());
    }
}
