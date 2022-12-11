import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Write a description of class LandPlot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LandPlot {

    Random random = new Random();
    private int[][] horizontalStrips;
    private int[][] borderLands;
    private int[][] landPeninsulas;
    private int[][] islands;

    public LandPlot(int length) {
        
        this.horizontalStrips = new int[length][];
        for (int i = 0; i < length; i++) {
            int[] horizontalStrip = new int[length];
            for (int p = 0; p < length; p++) {
                horizontalStrip[p] = random.nextInt(0,2);
            }

            horizontalStrips[i] = horizontalStrip;
        }
    }

    public int[][] getLandPlot() {
        return horizontalStrips;
    }

    public int[][] getBorderLands() {
        return borderLands;
    }

    public int[][] getLandPeninsulas() {
        return landPeninsulas;
    }

    public int[][] getIslands() {
        return islands;
    }

    private int[] singleLandStrip(int[][] arrayLandPlot) {
        return arrayLandPlot[0];
    }

    public void printLandStrips() {
        for (int[] landStrip : horizontalStrips) {
            System.out.println(Arrays.toString(landStrip));
        }
    }

    public void getIslands(int[][] landPlot) {

        int[][] arrayLandPlot = landPlot;
        int[] singleLandStrip = singleLandStrip(arrayLandPlot);
        int checkLimit = (int) Math.ceil(singleLandStrip.length/2)+1;
        int startCoordinates = 0;
        
        while (startCoordinates != checkLimit) {
            int[] thisLandStrip = arrayLandPlot[startCoordinates];
            for (int pos = 0; pos < thisLandStrip.length; pos++) {

            }

            startCoordinates++;
        }
    }

    public void findLand(int[][] landPlot) {

        if (borderLands != null) {
            System.out.println("Borderlands have already been found");
        } else {
        int collumn = 0;
        int row = 0;
        int plotLength = landPlot[0].length;
        ArrayList<int[]> landCoordinates = new ArrayList<>();


        while (!(collumn == 0 && row == 1)) {
            
            // Top Traverse
            if (collumn == 0 && row == 0) {
                int[] topStrip = landPlot[0];
                for (int coordinate : topStrip) {
                    if (coordinate == 1) {
                        int[] land = {row, collumn};
                        landCoordinates.add(land);
                    }
                    collumn++;
                }
                collumn--;
            } 
            
            // Right edge Traverse
            if (collumn == plotLength-1 && row == 0) {
                int r;
                for (r = row; r < plotLength; r++) {
                    int[] currentStrip = landPlot[r];
                    int coordinate = currentStrip[collumn];
                    if (coordinate == 1) {
                        int[] land = {r, collumn};
                        landCoordinates.add(land);
                    }
                }
                row = r-1;
            }
            
            //Bottom Traverse
            if (collumn == plotLength-1 && row == plotLength-1) {
                int[] bottomStrip = landPlot[row];
                while (collumn >= 0) {
                    int coordinate = bottomStrip[collumn];
                    if (coordinate == 1) {
                        int[] land = {row, collumn};
                        landCoordinates.add(land);
                    }
                    collumn--;
                }
                collumn++;
            }

            // Left Edge traverse
            if (collumn == 0 && row == plotLength-1) {
                row--;
                while (row > 1) {
                    int[] currentStrip = landPlot[row];
                    int coordinate = currentStrip[collumn];
                    if (coordinate == 1) {
                        int[] land = {row, collumn};
                        landCoordinates.add(land);
                    }
                    row--;
                }
            }
        }

        int[][] landCoordinatesArray = landCoordinates.toArray(new int[landCoordinates.size()][]);

        this.borderLands = landCoordinatesArray;
        }
    }
}
