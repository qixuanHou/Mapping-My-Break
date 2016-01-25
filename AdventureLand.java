

import java.util.Scanner;


public class AdventureLand {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            String newLine = keyboard.nextLine();
            if (args.length < 1) {
                System.out.println(newLine);
            } else {
                CharSequence keyWord = args[0];
                if (newLine.contains(keyWord)) {
                    System.out.println("OK" + "\r\n");
                } else {
                    System.out.println("\n");
                }
            }
        }
    }
}
