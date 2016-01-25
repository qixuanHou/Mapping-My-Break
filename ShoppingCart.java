/**
 * @author Qixuan Hou
 * @version 3/13/2014
 */

public class ShoppingCart {
    private ShoppingCartItem[] shoppingCartItems;
    private int size;
    private int counter;

    /**
     * Creates a ShoppingCart with an array of size 10
     */
    public ShoppingCart() {
        shoppingCartItems = new ShoppingCartItem[10];
        size = 10;
        counter = 0;
    }

    /**
     * add a ShoppingCartItem into the backing array
     *
     * @param item a ShoppingCarItem
     */
    public void add(ShoppingCartItem item) {
        if (counter == size) {
            ShoppingCartItem[] newS =
                    new ShoppingCartItem[2 * shoppingCartItems.length];
            for (int i = 0; i < shoppingCartItems.length; i++) {
                newS[i] = shoppingCartItems[i];
            }
            newS[shoppingCartItems.length] = item;
            shoppingCartItems = newS;
            size = shoppingCartItems.length;
            counter = counter + 1;
        } else {
            shoppingCartItems[counter] = item;
            counter = counter + 1;
        }
    }

    /**
     * remove a ShoppingCartItem from the backing array
     *
     * @param item a ShoppigCartItem
     * @return the item which remove from the backing array
     * or null when it does not match
     */
    public ShoppingCartItem remove(ShoppingCartItem item) {

        int i = 0;
        while (i < counter) {
            if (shoppingCartItems[i].equals(item)) {
                for (int j = i; j < counter - 1; j++) {
                    shoppingCartItems[j] = shoppingCartItems[j + 1];
                }
                counter = counter - 1;
                return item;
            } else {
                i = i + 1;
            }
        }
        return null;
    }
     /**
     * getter method to get the corresponding ShoppingCartItem
     *
     * @param integer the index the user want to get
     * @return the item which remove from the backing array
     * or null when it does not match
     */
    public ShoppingCartItem getItem(int i) {
        return shoppingCartItems[i];
    }
    /**
     * getter method to get counter
     *
     * @return the counter field
     */
    public int getCounter() {
        return counter;
    }
    /**
     * Override toString method in Object class
     *
     * @return  the String iterate through the
     * array to call toString to each of them
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < counter; i++) {
            result = result + shoppingCartItems[i].toString() + "\r\n";
        }
        return result;
    }
}

