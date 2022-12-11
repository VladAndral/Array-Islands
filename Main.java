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
                System.out.println("Input desired island size: ");
                
                while (!keyboard.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a a valid integer");
                    keyboard.next();
                }
    
                int size = keyboard.nextInt();
                keyboard.nextLine();
    
    
                LandPlot newLandPlot = new LandPlot(size);
        
                newLandPlot.printLandStrips();
                int[][] landPlot = newLandPlot.getLandPlot();
        
                newLandPlot.findLand(landPlot);
        
                int[][] borderLands = newLandPlot.getBorderLands();
                System.out.println();
        
                for (int[] landCoordinates : borderLands) {
                    System.out.println(Arrays.toString(landCoordinates));
                }

            }
            
        } while (choice != 0);

        keyboard.close();
        
    }
    


}
