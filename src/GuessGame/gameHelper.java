package GuessGame;

import java.util.*;

public class gameHelper {
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATTEMPTS = 200;
    static final int HORIZONTAL_INCREMENT = 1;
    static final int VERTICAL_INCREMENT = GRID_LENGTH;

    private final int[] grid = new int [GRID_SIZE];
    private final Random random = new Random();
    private int startUpCount = 0;

    public String getUserInput (String prompt) {
        System.out.print(prompt + ": ");
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase();
    } // end method getuserinput

    public ArrayList<String> placeStartup (int startupSize) {
        //holds index to grid (0-48)
        int[] startupCoords = new int [startupSize];
        //current candidate coords
        int attempts = 0;
        //current attempts at counter
        boolean success = false;
        // flag = found a good location?

        startUpCount++;
        //nth startup to place
        int increment = getIncrement();
        //alternate vert & horiz alignment

        while (!success & attempts++ < MAX_ATTEMPTS) {
            //main search loop
            int location = random.nextInt(GRID_SIZE);
            //get random starting point

            for (int i = 0; i <startupCoords.length; i++) {
                //create an array of proposed coords
                startupCoords[i] = location;
                //put current location into the array
                location += increment;
                //cacluate the next location
            } // end for loop
//            System.out.println("Trying: " + Arrays.toString(StartupCoords));

            if (startupFits (startupCoords, increment)) {
                //startup fits on the grid
                success = coordsAvailable(startupCoords);
            } // end if loop
        } // end while loop

        savePositionToGrid(startupCoords);
        //coords passed check, saved to grid
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);
//        System.out.println("Placed at: " + alphaCells);
        //uncommenting this is a cheat to tell you where the battleships are located
        return alphaCells;
    } // end placestartup method

    private boolean startupFits(int[] startupCoords, int increment) {
        int finalLocation = startupCoords[startupCoords.length-1];
        if (increment == HORIZONTAL_INCREMENT) {
            //check end is the same row as the start
            return calcRowFromIndex (startupCoords[0]) == calcRowFromIndex(finalLocation);
        } else {
            return finalLocation < GRID_SIZE;
            //check end is not off the bottom
        }// end if statement
    } // end startupfits

    private boolean coordsAvailable (int[] startupCoords) {
        for (int coord : startupCoords) {
            //check all potential positions
            if (grid[coord] != 0) {
                //position already taken
//               System.out.println("position: " + coord + " already taken!");
            return false;
            //No success
            }//end if loop
        }// end for loop
        return true;
        // no clashes, yay!
    } // end coords available method

    private void savePositionToGrid(int[] startupCoords) {
        for (int index : startupCoords) {
            grid[index] = 1;
            // mark grid position as "used"
        } // end for loop
    } // end savepositiontogrid method

    private ArrayList<String> convertCoordsToAlphaFormat (int[] starupCoords) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        for (int index : starupCoords) {
            // for each grid coordinate
            String alphaCoords = getAlphaCoordsFromIndex (index);
                    // turn into an "a0" style
            alphaCells.add(alphaCoords);
            //add to the list
        } // end for loop
        return alphaCells;
    } // end convertcoordstoalphaformat method

    private String getAlphaCoordsFromIndex(int index) {
        int row = calcRowFromIndex (index);
        //get row value
        int column = index % GRID_LENGTH;
        //get numeric column value
        String letter = ALPHABET.substring(column, column +1);
        //concert to letter
        return letter + row;
    } // end getalphacoordsfromindex

    private int calcRowFromIndex(int index) {
        return index / GRID_LENGTH;
    } // end calcrowfromindex

    private int getIncrement () {
        if (startUpCount % 2 == 0) {
            // if EVEN startup
            return HORIZONTAL_INCREMENT;
            //place Horizontally
        } else {
            return VERTICAL_INCREMENT;
            //place vertically
        } // end if statement
    } // end getincrement method
} // end class
