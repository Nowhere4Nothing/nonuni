package Headfirst.Jukebox;
import java.util.*;

public class SongV4 implements Comparable<SongV4> {
    private String title;
    private String artist;
    private String genre;
    private int timesPlayed;
    private int year;



    public boolean equals (Object aSong) {
        //the hashset (or anyone else calls it) sends it to another song
        SongV4 other = (SongV4) aSong;
        return title.equals(other.getTitle());
        // title is a string and its overridden equals() method. Need to ask one title if its equal to another title
    }

    public int hashCode() {
        return title.hashCode();
        //overriding the equals' method. returns the result.
        //if you override equals() you must override hashcode()
    }

    public int compareTo(SongV4 s) {
        return title.compareTo(s.getTitle());
    }

    SongV4(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.timesPlayed = timesPlayed;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", " +
                "Artist: " + artist + ", " +
                "Genre: " + genre + ", " +
                "Year made: " + timesPlayed + ", " +
                "Times played: " + timesPlayed + ". \n";
    }
}
