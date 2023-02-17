package GuessGame;
import java.util.ArrayList;

public class StartupBust {
    private gameHelper helper = new gameHelper();
    private ArrayList <Startup> startups = new ArrayList<Startup>();
    private int numbOfGuesses = 0;
    // declare and initialize the var needed

    public static void main (String[] args) {
        StartupBust game = new StartupBust();
        //create game object
        game.setupGame();
        //tell the game object to set up the game
        game.startPlaying();
        //tell the game object to start the main game play loop (keep asking for user input and checking the guess)
    } //close main method

    private void setupGame() {
        // make 3 start up objects (battleships), give them names, stick them in the arraylist
        Startup one = new Startup();
        one.setName("Osiris");
        Startup two = new Startup();
        two.setName("Repulse");
        Startup three = new Startup();
        three.setName("Dreadnought");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("**********************Game Launched***********************");
        System.out.println();
        System.out.println("Your goal is to sink the three battleships!");
        System.out.println("Osiris, Repulse, Dreadnought!");
        System.out.println("Try to sink all the Battleships in the least amount of guesses!");
        System.out.println("The battle ships will be placed on a grid designed like the one below. ");
        System.out.println();

        char c;

        for (c = 'a'; c<= 'g'; ++c) {
            System.out.print(c + " ");
            for (int j = 0; j <=6; j++) {

                System.out.print(j + " ");
            } // end inner for loop
             System.out.println();
        } // end outer for loop
        //Printing brief instructions for the user



        for (Startup startup : startups) {
            //repeat with each startup on the list
            ArrayList<String> newLocation = helper.placeStartup(3);
            //ask the helper for startup location
            startup.setLocationCells(newLocation);
            //call thesetter method on this startup to give it the location u judt got from the helper
        } // end for loop
    } //end setup game method

    private void startPlaying() {
while (!startups.isEmpty()) {
    //as long as the startup list is not empty (the ! means NOT, its the same as startups.isEmpty() == false
    System.out.println();
    String userGuess = helper.getUserInput ("Enter a guess");
    //get user input
    checkUserGuess (userGuess);
    //call our own checkUserGuess method
} // end while loop
        finishGame();
        //call our own finishGame method
    } // end startPlaying method

    private void checkUserGuess(String userGuess) {
        numbOfGuesses++;
        //add the number of guesses the user has made
        String result = "miss";
        //Assume its a miss unless told otherwise

        for (Startup startupToTest : startups) {
            //repeat with all startups on the list
            result = startupToTest.checkYourself(userGuess);
            //Ask the startup to check the user guess, looking for a hit (or kill)

            if (result.equals("hit")) {
                break;
                //Get out of the loop early, no use testing others
            } // end if statment

            if (result.equals("kill")) {
                startups.remove(startupToTest);
                break;
                //this ones dead so take it out od the startup list then out of the loop
            } // end if statement
        } // end for loop

        System.out.println(result);
        //Print a result for the user
    } // end method checkUserGuess

    private void finishGame() {
        System.out.println("All Battleships are dead! You survived!");
        if (numbOfGuesses <=15) {
            System.out.println("Winner, Winner, Chicken Dinner! it only took you " + numbOfGuesses + " guesses!");
            System.out.println("You killed them all, before they got you!");
        } else if ((numbOfGuesses > 15) && (numbOfGuesses <= 25)){
            System.out.println("So close, nearly perfect. Better luck next time!");
            System.out.println("You killed them all, but took some casualties!");
        } else if ((numbOfGuesses > 25) && (numbOfGuesses <= 35)) {
            System.out.println("");
            System.out.println("You survived by the skin of your teeth! At least you got them all");
        } else {
            System.out.println("Damn, mate. Took you long enough!");
            System.out.println("You finished but They killed you! your navy is sleeping with the fishes");
            //Print a message telling the user how they went
            System.out.println("*****************************Program Terminated*********************");
        }//end first if statement
    } // end method finishGame

} // end class
