/**
 * @author Qixuan Hou
 * @version 3/13/2014
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;

public class MainStreet {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        
        Buyable a = new Bowl("Macaroni & Cheese Burger", 10.49);
        Buyable c = new Bowl("Vegetarian FlatBread", 9.69);
        Buyable s = new Bowl("Meatball Sub", 9.19);
        Buyable e = new Bowl("Hand-tossed Caesar with Chicken", 7.99);
        Buyable f = new Bowl("Chicken Breast Nuggets(8 pieces)", 8.69);
        Buyable g = new Bowl("Kids' Mealts", 5.99);        


        ShoppingCart myShoppingCart = new ShoppingCart();

        System.out.println("\nWelcome to the Plaza Restaurant!\n");


        boolean b = true;
        while (b) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: order the dish");
            System.out.println("2: List your dishes");
            System.out.print("3: Checkout and Exit\nEnter option number: ");
            int number = keyboard.nextInt();
            if (number == 1) {
            System.out.println("\nWhat would you like to order?");
            System.out.println("\nThis is our menu:\n");
            System.out.println("1. " + a.toString());
            System.out.println("1/3 lb Angus Beef topped with Bacon Cheddar Cheese,");
            System.out.println("and Baked Macaroni Cheese served with Grapes or French Fries\n");

            System.out.println("2. " + c.toString());
            System.out.println("Tomato Pesto Base topped with Mushrooms,");
            System.out.println("Feta Cheese, and Angula\n");

            System.out.println("3. " + s.toString());
            System.out.println("Served with Grapes or French Fries\n");

            System.out.println("4. " + e.toString());
            System.out.println("Romaine, Grilled Chicken, Parmesan, and Caesar Dressing\n");

            System.out.println("5. " + f.toString());
            System.out.println("Served with Grapes or French Fries\n");

            System.out.println("6. " + g.toString());
            System.out.println("Chilled Chicken Wrap\n");



            System.out.print("Enter the number of the dish");
            System.out.print(" you'd like to add: ");
                int productNum = keyboard.nextInt();
                ShoppingCartItem theItem = new ShoppingCartItem(a);
                
                if (productNum ==  1) {
                    theItem = new ShoppingCartItem(a);                    
                } else if (productNum == 2) {                  
                    theItem = new ShoppingCartItem(c);
                } else if (productNum == 3) {
                    theItem = new ShoppingCartItem(s);
                } else if (productNum == 4) {
                    theItem = new ShoppingCartItem(e);
                } else if (productNum == 5) {
                    theItem = new ShoppingCartItem(f);
                } else if (productNum == 6) {
                    theItem = new ShoppingCartItem(g);
                } 
                theItem.setQuantity(1);
                myShoppingCart.add(theItem);

                System.out.println("ordered dish:");
                System.out.println(theItem.toString());
               
            } else if (number == 2) {
                System.out.println("\nHere are the dishes you ordered: ");
                System.out.println(myShoppingCart.toString());

            } else if (number == 3) {
                System.out.print("\nThank you! Please take");
                System.out.println(" your receipt (see RestaurantReceipt.txt)");
                File outFile = new File("RestaurantReceipt.txt");
                PrintStream output = new PrintStream(outFile);
                String contents = myShoppingCart.toString();
                output.println("Restaurant Receipt\r\n");
                output.println("Here are your purchases:");
                output.println(contents + "\r\n");
                double cost = 0;
                for (int i = 0; i < myShoppingCart.getCounter(); i++) {
                    cost = cost + myShoppingCart.getItem(i).calculateCost();
                }
                output.println("Total = " + us.format(cost));
                output.println("\r\nThank you!");
                System.exit(0);
            }
        }

    }
}
