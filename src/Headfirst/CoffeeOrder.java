package Headfirst;
import java.util.*;
import java.util.stream.*;

public class CoffeeOrder {
    public static void main (String[] args) {
        List<String> coffees = List.of("Cappuccino", "Americano", "Expresso", "Cortado", "Mocha", "Cappuccino", "Flat white", "Latte");
        List <String> coffeesEndingInO = coffees.stream()
                .sorted()
                .distinct()
                .filter(s -> s.endsWith("o"))
                .collect(Collectors.toList());

        System.out.println(coffees);
        System.out.println(coffeesEndingInO);
        System.out.println();

        List<String> sentence = List.of("I", "am", "a", "very", "boring", "and", "long", "Sentence");
        List <String> result = sentence.stream()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(sentence);
        System.out.println(result);

    } // end main
} // end class
