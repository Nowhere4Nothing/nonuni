package HackerRank;

import java.io.*;
import java.util.*;

public class person {
    private int age;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("this program is designed to tell u if u are old!");
        System.out.println("insert amount of ages wanted in this test");
        String firstTest = input.nextLine();
        int firstAgeTest = Integer.parseInt(firstTest);

        System.out.println("how many years do you want to skip?");
        String secondIn = input.nextLine();
        int skip = Integer.parseInt(secondIn);

        int i, j;
        for (i = 0; i < firstAgeTest; i++) {
            System.out.println("Insert age");
            int age = input.nextInt();
            person them = new person(age);
            them.amIold();

            for (j = 0; j < skip; j++) {

                them.yearPasses();
            }
            System.out.println("After the time skip!");
            if (age < 0) {
                age = 0;
                int Tage = age + skip;
                System.out.println(Tage);
            }
            them.amIold();

            System.out.println();
        }
        input.close();
    }

    public person(int initialAge) {
        //adding code to check for initial age

        if (initialAge < 0) {
            this.age = 0;
            System.out.println("Age is not valid, setting age to 0.");
        }
        this.age = initialAge;
    }

    public void amIold() {
        //doing the if statement to print at the desired ages
        if (this.age < 13) {
            System.out.println("You are young.");
        } else if ((this.age >= 13) && (this.age < 18)) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are old.");
        }
    }

    public void yearPasses() {
        //age will increase
        age++;
    }
}

