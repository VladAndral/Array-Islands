import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * LandPlot makes an array of 1's and 0's and considers 0's water, 1's land.
 * {@code findLand} is a recursive method that finds all the land
 * connected to land at the border
 *
 * @author Vladimir Andral
 * @version 17/2/2023
 */
public class LandPlot {
    Random random = new Random();
    private final int[][] landPlot;
    private int[][] islandCoordinates;
    private ArrayList<int[]> landPeninsulas = new ArrayList<>();
    private final int landMarker;
    private ArrayList<int[]> islands = new ArrayList<>();

    public LandPlot(int length, int landMarker) {

        this.landMarker = landMarker;
        
        // Setting the field landPlot
        this.landPlot = new int[length][];
        for (int i = 0; i < length; i++) {
            int[] horizontalStrip = new int[length];
            for (int p = 0; p < length; p++) {
                horizontalStrip[p] = random.nextInt(0,2);
            }
            landPlot[i] = horizontalStrip;
        }

    }
    
    public LandPlot(int length, int height, int landMarker) {

        this.landMarker = landMarker;
        
        // Setting the field landPlot
        this.landPlot = new int[height][length];
        for (int i = 0; i < height; i++) {
            int[] horizontalStrip = new int[length];
            for (int p = 0; p < length; p++) {
                horizontalStrip[p] = random.nextInt(0,2);
            }
            landPlot[i] = horizontalStrip;
        }

    }

    public int[][] getLandPlot() {
        return landPlot;
    }

    public int[][] islandCoordinates() {
        return islandCoordinates;
    }


    public int[][] getLandPeninsulas() {
        return landPeninsulas.toArray(new int[landPeninsulas.size()][]);
    }

    private void getIslands() {
        for (int y = 0; y < landPlot.length; y++) {
            for (int x = 0; x < landPlot[0].length; x++) {
                if (landPlot[y][x] == 1) {
                    int[] toAdd = {y+1, x+1};
                    islands.add(toAdd);
                }
            }
        }
        islandCoordinates = islands.toArray(new int[islands.size()][islands.size()]);
    }

    public void printPlot() {
        for (int[] landStrip : landPlot) {
            System.out.println(Arrays.toString(landStrip));
        }
    }


    public void findLands() {
        
        int x = 0;
        int y = 0;

        while (x < landPlot[0].length) {

            if (landPlot[y][x] == 1) {
                recursiveFindLands(y, x);
            }
            x++;
        }
        x--;

        y++;

//        right side, moving down
        while (y < landPlot.length) {
            if (landPlot[y][x] == 1) {
                recursiveFindLands(y, x);
            }
            y++;
        }
        y--;
        
//        bottom, moving left
        x--;
        while (x >= 0) {
            if (landPlot[y][x] == 1) {
                recursiveFindLands(y, x);
            }
            x--;
        }
        x++;
        
        y--;
        while (y >= 0) {
            if (landPlot[y][x] == 1) {
                recursiveFindLands(y, x);
            }
            y--;
        }
        getIslands();
    }

    private void recursiveFindLands(int y, int x) {

        landPlot[y][x] = landMarker;
        int[] toAdd = new int[2];
        toAdd[0] = y+1;
        toAdd[1] = x+1;

        landPeninsulas.add(toAdd);

        // While not on left edge
        if (x != 0) {
            if (landPlot[y][x-1] == 1) {
                recursiveFindLands(y, x-1);
            }
        }
        
        //While not at bottom
        if (y != landPlot.length-1) {
            if (landPlot[y+1][x] == 1) {
                recursiveFindLands(y+1, x);
            }
        }
        
        //While not at right edge
        if (x != landPlot[0].length-1) {
            if (landPlot[y][x+1] == 1) {
                recursiveFindLands(y, x+1);
            }        }
        
        //While not at left edge
        if (y != 0) {
            if (landPlot[y-1][x] == 1) {
                recursiveFindLands(y-1, x);
            }        
        }
    }
}
        


 