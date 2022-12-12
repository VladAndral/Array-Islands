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
    private int[][] landPlot;
    private int[][] borderLands;
    private int[][] landPeninsulas;
    private int[][] islands;
    private int landStripLength;

    public LandPlot(int length) {

        landStripLength = length;
        
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

    public int[][] getLandPlot() {
        return landPlot;
    }

    public int[][] getBorderLands() {
        return borderLands;
    }

    public int[][] getLandPeninsulas() {
        return landPeninsulas;
    }

    public void printLandStrips() {
        for (int[] landStrip : landPlot) {
            System.out.println(Arrays.toString(landStrip));
        }
    }

    // Should this return void?
    public void getIslands() {

        // // Recheck what variables are needed, should some be fields?
        // int[][] arrayLandPlot = landPlot;
        // int[] singleLandStrip = singleLandStrip(arrayLandPlot);
        // int checkLimit = (int) Math.ceil(singleLandStrip.length/2)+1;
        // int[] checkLimitCoordinates = {checkLimit, checkLimit};
        // int startCoordinates = 0;
        
        // while (startCoordinates != checkLimit) {
        //     int[] thisLandStrip = arrayLandPlot[startCoordinates];
        //     for (int pos = 0; pos < thisLandStrip.length; pos++) {

        //     }

        //     startCoordinates++;
        // }

        // // Attempt at recursive method
        // if (checkLimitCoordinates[0] == checkLimit) {

        // }

        this.getIslands();



    }

    // Public or private?
    public void findBorderlands() {
        
        ArrayList<int[]> landCoordinates = new ArrayList<>();
        if (borderLands != null) {
            System.out.println("Borderlands have already been found");
        } else if (landStripLength == 2) {
            System.out.println("A 2x2 plot cannot have any islands");
            for (int row = 0; row < landStripLength; row++) {
                for (int collumn = 0; collumn < landStripLength; collumn++) {
                    if (landPlot[row][collumn] == 1) {
                        int[] land = {row, collumn};
                        landCoordinates.add(land);
                    }
                }
            }
            int[][] landCoordinatesArray = landCoordinates.toArray(new int[landCoordinates.size()][]);
            this.borderLands = landCoordinatesArray;    
        } else {

            int collumn = 0;
            int row = 0;
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
                if (collumn == landStripLength-1 && row == 0) {
                    int r;
                    for (r = row; r < landStripLength; r++) {
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
                if (collumn == landStripLength-1 && row == landStripLength-1) {
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
                if (collumn == 0 && row == landStripLength-1) {
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
            
            // Creating/Adding all borderLands to the field
            this.borderLands = landCoordinatesArray;
        }
    }


    // Should return something
    private void findIslands() {

        if (islands != null) {

            if (landStripLength == 2) {
                System.out.println("A 2x2 plot cannot have any islands");
            } else if (landStripLength == 3) {
                if (borderLands == null && landPlot[1][1] == 1) {
                    int[] island = {1, 1};
                    this.islands = new int[1][1];
                    this.islands[0] = island;
                } else {
                    System.out.println("No islands found");
                }
            }
        }


    }



} // Class
