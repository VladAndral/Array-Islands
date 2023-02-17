import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int choice;
        do {
            for (int dash = 0; dash <= 40; dash ++){
                System.out.print("-");
            }
            System.out.println();
            System.out.println("         Array Island Menu");
            for (int dash = 0; dash <= 40; dash ++){
                System.out.print("-");
            }

            System.out.println();
            System.out.println("Do you want to do this? 0 if no any other integer if yes");
            while (!keyboard.hasNextInt()) {
                System.out.println("Invalid input. Please enter a a valid integer");
                keyboard.next();
            }
            choice = keyboard.nextInt();
            keyboard.nextLine();
            if (choice != 0) {
                System.out.println();
                System.out.println("Input desired island length: ");

                while (!keyboard.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a a valid integer");
                    keyboard.next();
                }

                int length = keyboard.nextInt();
                keyboard.nextLine();

                System.out.println();
                System.out.println("Input desired island height, \nfor a square input same as previous: ");

                while (!keyboard.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a a valid integer");
                    keyboard.next();
                }

                int height = keyboard.nextInt();
                keyboard.nextLine();


                System.out.println();
                System.out.println("Input desired land marker: ");

                while (!keyboard.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a a valid integer");
                    keyboard.next();
                }

                int landMarker = keyboard.nextInt();
                keyboard.nextLine();

                LandPlot newLandPlot = new LandPlot(length, height, landMarker);

                System.out.println("Your plot of land: ");
                newLandPlot.printPlot();
                System.out.println("Your plot, with land connected to the border marked: ");
                newLandPlot.findLands();
                newLandPlot.printPlot();

                if (newLandPlot.islandCoordinates().length == 0) {
                    System.out.println("No islands exist for this plot");
                } else {
                    System.out.println("Would you like the coordinates for islands? (y/n)");
                    String islandChoice = "9";
                    boolean correctInput = false;
                    while (!correctInput) {
                        islandChoice = keyboard.nextLine();
                        if (!(islandChoice.equals("y") || islandChoice.equals("n"))) {
                            System.out.println("Enter 'y' for yes or 'n' for no");
                        } else {
                            correctInput = true;
                        }
                    }
                    if (islandChoice.equals("y")) {
                        System.out.println("Island coordinates: ");
                        int[][] islands = newLandPlot.islandCoordinates();
                        for (int i = 0; i < islands.length; i++) {
                            System.out.print(Arrays.toString(islands[i]));
                            if ((i+1)%3 == 0) {
                                System.out.println();
                            }
                        }
                    }
                }
                System.out.println("\nPress <Enter> to continue");
                keyboard.nextLine();
            }
        } while (choice != 0);
        keyboard.close();
    }
}
