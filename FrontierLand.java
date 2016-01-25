import java.util.Scanner;

public class FrontierLand {

    public static void main(String[] args) throws Exception {
        CandyMountain world;
        System.out.println("\nWelcome to Big Thunder Mountain Railroad\n");
        System.out.println("Ride through a gold-mining town on a runaway train\n\n\n\nRules:");
        System.out.println("Your task is to find the gold mine in haunted thunder Mountain");
        System.out.println("You may encounter traps. Once you are in the trap, your train will be broken. You cannot move.....");
        System.out.println("In order to find the gold mine, please find Aladdin's Wonderful lamp first. It will show you map with position of traps and gold mine.");
        System.out.println("Good Luck!");
        int initialHealth = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        world = (args.length > 1)
            ? new TrappedCandyMountain(Integer.parseInt(args[1]))
            : new CandyMountain();
        Quester quester = new Quester("train", initialHealth);
        Scanner keyboard = new Scanner(System.in);
        boolean gameOver = false;
        do {
            System.out.println(world);
            System.out.println(quester.getName() + "'s remained times: "
                               + quester.getHealth());
            System.out.println("Enter N, S, E, or W to move "
                               + quester.getName());
            String input = keyboard.nextLine().toUpperCase();
            Move move = CandyMountain.SOUTH;
            if (input.equals("N")) { move = CandyMountain.NORTH; }
            if (input.equals("E")) { move = CandyMountain.EAST; }
            if (input.equals("W")) { move = CandyMountain.WEST; }
            if (input.equals("S")) { move = CandyMountain.SOUTH; }
            int cost = world.moveQuester(move);
            if (cost == -1) {
                System.out.println("Invalid move: " + input);
            } else {
                quester.updateHealth(-cost);
            }
            if (world.hasSeenLiopleurodon()) {
                System.out.println("The Aladdin's Wonderful lamp has spoken! "
                                   + "GOLD MINE is nigh!");
            }
            gameOver = !quester.isAlive() || world.hasReachedGoal();
        } while (!gameOver);
        if (quester.isAlive()) {
            System.out.println("You found Good Mine!  Good bye, "
                               + quester.getName() + "!");
        } else {
            System.out.println("You run out of time, sorry.");
        }
    }
}
