 import java.util.Scanner;

public class Disney {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Walt Disney World!\n");
		System.out.println("Create and Manage Your Walt Disney World Experience\n");
		System.out.println("What is your name?");
		String name = keyboard.nextLine();
		System.out.println("\nWhen was your trip?");
		String date = keyboard.nextLine();
		System.out.println("\n\n\n\nLoading...\n");
		System.out.println(date);		
		System.out.println("Hello," + name);
		System.out.println("You can begin to map your day in Magic Kingdom, the best part of Walt Disney World\n\n\n\n");


        System.out.println("Magic Kingdom is formed by six parts");



		boolean b = true;
		while (b) {
        	System.out.println("\n\n\n\n\n\nThese are six parts: ");
			System.out.println("  1. Main Street, U.S.A");
			System.out.println("  2. Adventure Land");
			System.out.println("  3. Frontier Land");
			System.out.println("  4. Liberty Square");
			System.out.println("  5. Fantasy Land");
			System.out.println("  6. Tomorrow Land");
			System.out.println("Enter the number of the part you want to visit or enter -1 if you finish");
			int number = keyboard.nextInt();
			if (number == 1 ) {
				System.out.println("Welcome to Main Street, U.S.A");
				System.out.println("Entering Disney fantasy land though the main street, you can find plentiful stores for Disney products.\n\n");
				System.out.println("if it's lunch time, why not have a great meal in Plaza Restaurant.");
			

			} else if (number == 2) {
				System.out.println("Welcome to Adventure Land");
				System.out.println("Do you know Woody, the toy all the other toys look up to?");
				System.out.println("He is smart, kind, and brave like a cowboy should be.");
				System.out.println("He wants to play with you today.");
			    System.out.println("Now, you can guide him to do anything you want him to do, but remember,");
			    System.out.println("You need to call his name first, or he will get mad.......\n\n");


			} else if (number == 3 ) {
				System.out.println("Welcome to Frontier Land");


			} else if (number == 4 ) {
				System.out.println("Welcome to Liberty land");
				System.out.println("Let's take a quiz to test your knowledge of American presidents.");
				System.out.println("Please enter 1 if the year and the name of president match, otherwise please enter 2");
				
				System.out.println("1. George Washington 1789 - 1797");
				if (keyboard.nextInt() == 1) {
					System.out.println("Good job");
				} else {
					System.out.println("he is the first president, and the statement is correct.");
				}
				System.out.println("2. Barack Obama 2009 - now");
			    if (keyboard.nextInt() == 1) {
					System.out.println("Excellent");
				} else {
					System.out.println("sorry, you may need to read more news everyday");
				}
				System.out.println("3. Abraham Lincoln 1861 - 1864");
			    if (keyboard.nextInt() == 2) {
					System.out.println("Excellent");
				} else {
					System.out.println("the correct statement: Abraham Lincoln 1861 - 1865");
				}

			} else if (number == 5 ) {
				System.out.println("Welcome to Fantasy land");
				System.out.println("Experience all-new magic as Magic Kingdom park comes alive with music and dancing in this parade celebrating Fantasyland.");
				

			} else if (number == 6 ) {
				System.out.println("Welcome to Tomorrowland");
				System.out.println("You can enter the world as desribed by sci-fi writers. With this imaginaive decor, Tomorrowland is the \"Future That Never Was.\"\n\n\n");
				System.out.println("You can talk with Alien, Stitch.");
				System.out.println("and " + name + ", you can also bring Stitch home.\n\n\n");
			} else if (number == -1) {
				System.out.println("Bye, " + name);
				System.exit(0);
			}
		}


		



	}
 
}
