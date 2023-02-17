package GuessGame;
import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells;
    private String name;
    // Startups instance var:
    // 1. an array list of cell locations
    // 2. the startups name

    public void setLocationCells (ArrayList<String> loc) {
        locationCells = loc;
    } // end method setLocationCells

    public void setName (String n) {
        name = n;
        //basic setter method
    } //  end setter method

    public String checkYourself (String userInput) {
       String result = "miss";
       int index = locationCells.indexOf(userInput);
       // if the userguess is one of the entries in arraylist, this will return its arraylist location. if not itll return -1
        if (index >= 0) {
            locationCells.remove(index);
            //using the array.remove() to delete an entry

            if (locationCells.isEmpty()) {
                //using the is.Empty to see if all the locations have been guessed
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
                //tell user the battleship has been sunk
            } else {
                result = "hit";
            } // end inner if statement
        } // end outer if statement
        return result;
    } // end checkYourself method
} // end class
