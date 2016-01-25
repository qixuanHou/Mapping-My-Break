/**
 * @author Qixuan Hou
 * @version 3/13/2014
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;

public class TomorrowLand {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        Buyable a = new DryGood("large Stitch", 21.95);
        Buyable s = new Good("Stitch key chain", 4.95);
        Buyable c = new DryGood("Stitch plush pillow", 32.95);


        ShoppingCart myShoppingCart = new ShoppingCart();

        System.out.println("\nWelcome to Stitch store!\n");


        boolean b = true;
        while (b) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: Add item to cart");
            System.out.println("2: Remove item from cart");
            System.out.println("3: List cart contents");
            System.out.print("4: Checkout and Exit\nEnter option number: ");
            int number = keyboard.nextInt();
            if (number == 1) {
                System.out.println("\nWe carry the following kinds of products:");
                System.out.println("1. " + a.toString());
                System.out.println("2. " + c.toString());
                System.out.println("3. " + s.toString());
                System.out.print("Enter the number of the product");
                System.out.print(" you'd like to add: ");
                int productNum = keyboard.nextInt();
                ShoppingCartItem theItem = new ShoppingCartItem(a);
                if (productNum ==  1) {
                    theItem = new ShoppingCartItem(a);
                    System.out.print("\n" + a.getQuantityQuery());
                } else if (productNum == 2) {
                    System.out.print("\n" + c.getQuantityQuery());
                    theItem = new ShoppingCartItem(c);
                } else if (productNum == 3) {
                    System.out.print("\n" + s.getQuantityQuery());
                    theItem = new ShoppingCartItem(s);
                }
                int quantity = keyboard.nextInt();
                theItem.setQuantity(quantity);
                myShoppingCart.add(theItem);

                System.out.println("Added item:");
                System.out.println(theItem.toString());

            } else if (number == 2) {
                System.out.println("\nHere are your cart contents: ");
                System.out.println(myShoppingCart.toString());
                System.out.print("\nEnter the name of");
                System.out.println(" the product you want to remove: ");
                String name = keyboard.nextLine();
                name = keyboard.nextLine();
                if ((!(name.equals(((GroceryItem) a).getName())))
                        && (!(name.equals(((GroceryItem) c).getName())))
                        && (!(name.equals(((GroceryItem) s).getName())))) {
                    System.out.print("\nI am sorry, I am afraid");
                    System.out.print(" I cannot do that.");
                    System.out.println(" No such item found...");
                } else {
                    Buyable dele = new ProduceItem(name, 2.00);
                    ShoppingCartItem remove = new ShoppingCartItem(dele);
                    System.out.print("\nEnter the quantity ");
                    System.out.println("you want to remove: ");
                    int n = keyboard.nextInt();
                    remove.setQuantity(n);
                    ShoppingCartItem removed = myShoppingCart.remove(remove);
                }
                System.out.println("\nHere are your cart contents:");
                System.out.println(myShoppingCart.toString());

            } else if (number == 3) {
                System.out.println("\nHere are your cart contents: ");
                System.out.println(myShoppingCart.toString());

            } else if (number == 4) {
                System.out.print("\nThank you! Please take");
                System.out.println("your receipt (see Receipt.txt)");
                File outFile = new File("Receipt.txt");
                PrintStream output = new PrintStream(outFile);
                String contents = myShoppingCart.toString();
                output.println("Stitch Store Receipt\r\n");
                output.println("Here are your purchases:");
                output.println(contents + "\r\n");
                double cost = 0;
                for (int i = 0; i < myShoppingCart.getCounter(); i++) {
                    cost = cost + myShoppingCart.getItem(i).calculateCost();
                }
                output.println("Total = " + us.format(cost));
                output.println("\r\nThank you!");
            }
        }

    }
}
