package HackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class Ex5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        formula(n);
    }
    public static void formula(int firstNumber) {

        for (int i = 1; i<=10; i++) {

            int total = i*firstNumber;

            System.out.print(firstNumber);
            System.out.print(" x ");
            System.out.print(i);
            System.out.print(" = ");
            System.out.print(total);
            System.out.print("\n");



        }System.out.println();
    }
}
