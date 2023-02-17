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

public class ex2 {




        /*
         * Complete the 'solve' function below.
         *
         * The function accepts following parameters:
         *  1. DOUBLE meal_cost
         *  2. INTEGER tip_percent
         *  3. INTEGER tax_percent
         */


        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("please insert the meal price");

            double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

            System.out.println("please insert the tip percentage");
            int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

            System.out.println("please insert the tax percentage");
            int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

            solve(meal_cost, tip_percent, tax_percent);

            bufferedReader.close();
        }

        public static void solve(double meal_cost, int tip_percent, int tax_percent) {
            // Write your code here


            double mealTip = (meal_cost/100*tip_percent);

            double mealTax = (tax_percent*meal_cost)/100;

            double total_cost = meal_cost + mealTip + mealTax;

            int totalCost = (int) Math.round (total_cost);

            System.out.println (totalCost);



        }

    }



