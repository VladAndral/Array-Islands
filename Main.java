import java.util.Arrays;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {

    public static void main(String[] args) {
        
        LandPlot newLandPlot = new LandPlot(9);

        newLandPlot.printLandStrips();
        int[][] landPlot = newLandPlot.getLandPlot();

        newLandPlot.findLand(landPlot);

        int[][] borderLands = newLandPlot.getBorderLands();
        System.out.println();

        for (int[] landCoordinates : borderLands) {
            System.out.println(Arrays.toString(landCoordinates));
        }



    }


}
