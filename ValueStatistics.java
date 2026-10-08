/*
 * ValueStatistics.java
 * Reads five floating-point values with a while loop, then reports the
 * total, average, maximum, minimum, and interest on the total at 20%.
 *
 * Author: Logan Harris
 * Date:   October 8, 2026
 */

import java.util.Scanner;

public class ValueStatistics {

    public static void main(String[] args) {

        final int REQUIRED = 5;        // how many values we need
        final int MAX_ATTEMPTS = 10;   // hard ceiling on loop passes
        final double RATE = 0.20;      // interest rate of 20%

        Scanner input = new Scanner(System.in);

        int count = 0;         // valid values accepted so far
        int attempts = 0;      // every pass, valid or not
        double total = 0.0;
        double maximum = 0.0;
        double minimum = 0.0;

        System.out.println("Please enter 5 numeric values.");

        // The loop ends when 5 values are accepted OR the attempt
        // ceiling is reached, so it can never run forever.
        while (count < REQUIRED && attempts < MAX_ATTEMPTS) {

            attempts++;
            System.out.print("Enter value " + (count + 1) + " of 5: ");

            if (input.hasNextDouble()) {
                double value = input.nextDouble();

                // Seed max and min with the first value rather than 0,
                // so that a set of all-negative numbers still works.
                if (count == 0) {
                    maximum = value;
                    minimum = value;
                } else {
                    if (value > maximum) {
                        maximum = value;
                    }
                    if (value < minimum) {
                        minimum = value;
                    }
                }

                total += value;
                count++;

            } else if (input.hasNext()) {
                // Discard the bad token. Without this the scanner would
                // read the same text forever and the loop would hang.
                String bad = input.next();
                System.out.println("  \"" + bad + "\" is not a number.");

            } else {
                System.out.println("  No more input available.");
                break;
            }
        }

        // Only report results if all five values were collected.
        if (count < REQUIRED) {
            System.out.println();
            System.out.println("Stopped after " + attempts + " attempts.");
            System.out.println("Only " + count + " of 5 values were entered.");
        } else {
            double average = total / REQUIRED;
            double interest = total * RATE;

            System.out.println();
            System.out.println("========== Results ==========");
            System.out.printf("Total:             %.2f%n", total);
            System.out.printf("Average:           %.2f%n", average);
            System.out.printf("Maximum:           %.2f%n", maximum);
            System.out.printf("Minimum:           %.2f%n", minimum);
            System.out.printf("Interest at 20%%:   %.2f%n", interest);
        }

        input.close();
    }
}
