package Headfirst;
import java.util.*;

public class SortMountains {
    public static void main (String [] args) {
        new SortMountains().go();
    }

    public void go() {
        List <Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain ("Longs", 14255));
        mountains.add(new Mountain ("Elbert", 14433));
        mountains.add(new Mountain ("Maroon", 14156));
        mountains.add(new Mountain ("Castle", 14265));

        mountains.sort((mount1, mount2) -> mount1.name.compareTo(mount2.name));
        System.out.println("by name:\n" + mountains);

        mountains.sort((mount1, mount2) -> mount1.height - mount2.height);
        System.out.println("by height:\n" + mountains);
    }
}
