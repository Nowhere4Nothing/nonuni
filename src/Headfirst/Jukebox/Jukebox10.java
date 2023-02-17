package Headfirst.Jukebox;
import java.util.*;
import java.util.stream.*;

public class Jukebox10 {
    public static void main (String [] args) {
        new Jukebox10().go();
    }

    public void go() {
        System.out.println("The song list!");
        List<SongV4> songList = MockSongs.getSongsV4();
        System.out.println("Using a TreeSet to sort and remove Duplicates");
        Set<SongV4> songV5Set = new TreeSet<>(songList);
        System.out.println(songV5Set);
        System.out.println();
        System.out.println();


        System.out.println("What Song would you like to filter");
        Scanner input = new Scanner (System.in);
        String input1 = input.nextLine();

        System.out.println();

        List<SongV4> userInput = songList.stream()
                .filter(songV4 -> songV4.getGenre().equals(input1))
                .collect(Collectors.toList());

        List<SongV4> userInput1 = songList.stream()
                .filter(songV4 -> songV4.getTitle().equals(input1))
                .collect(Collectors.toList());

        List<SongV4> userInput2 = songList.stream()
                .filter(songV4 -> songV4.getArtist().equals(input1))
                .collect(Collectors.toList());

        List<SongV4> newList = Stream.of(userInput, userInput1, userInput2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        // Stream putting all 3 streams into one to display


        if (newList.isEmpty()) {

            System.out.println("Sorry invalid search input!");
        } else {
            System.out.println("Displaying results");
            System.out.println(newList);
        }


//        System.out.println("Sorted but with duplicates");
//        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
//        //this is a lambda
//        System.out.println(songList);
//        System.out.println();
//
//        System.out.println("Using a hashset to get rid of duplicates but not sorted");
//        Set<SongV4> songV4Set = new HashSet<>(songList);
//        System.out.println(songV4Set);
//        System.out.println();
//
//        System.out.println("Using a TreeSet to sort and remove Duplicates");
//        Set<SongV4> songV5Set = new TreeSet<>(songList);
//        System.out.println(songV5Set);
//        System.out.println();
//
//        System.out.println("Using a TreeSet to Sort by BPM");
//        Set<SongV4> songV6Set = new TreeSet<>(((o1, o2) -> o1.getBpm() - o2.getBpm()));
//        //using a lambda to sort via bpm
//        songV6Set.addAll(songList);
//        //adding all the treeSet songs to it
//        System.out.println(songV6Set);
//        System.out.println();

    } // end method go
} // end class
