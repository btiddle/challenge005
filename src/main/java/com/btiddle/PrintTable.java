package com.btiddle;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Scanner;

/*

Program currently coded to
Max input value = max long = 9,223,372,036,854,775,807.

9223372036854775807

Converting values to BigInteger to perform the product results in a max value of
85,070,591,730,234,615,847,396,907,784,232,501,249.

 */

public class PrintTable {

    private static String usage =
        "\nprimetable: Print a multiplication table of prime numbers.\n" +
        " Enter a table size equal to or greater than 1.\n";

    static public long getInput(Scanner scanner, PrintWriter output) {
        long size = -1;

        try {
            output.print("Enter table size: ");
            output.flush();

            String input = scanner.nextLine();

            output.print("\n");
            output.flush();

            if (input == null || input.isEmpty())
                throw new IllegalArgumentException("ERROR: Empty string is an invalid input value.");

            if (input.contains(" "))
                throw new IllegalArgumentException("ERROR: Spaces are not allowed in input value.");

            try {
                size = Long.parseLong(input);
                if (size < 1) {
                    size = -1;
                    throw new NumberFormatException();
                }
            } catch (java.lang.NumberFormatException e) {
                throw new IllegalArgumentException("ERROR: Input is not a valid number.");
            }
        } catch (Exception e) {
            output.println(e.getMessage() + usage);
        }
        return (size);
    }

    static long[] getPrimes(Long goal) {
        if (goal < 1)
            throw new NumberFormatException();

        LinkedHashSet<Long> primeSet = new LinkedHashSet<>();
        primeSet.add(2l);
        long number = 3;

        next_number:
        while (primeSet.size() < goal) {
            if (number % 2 == 0) {
                number++;
            } else {
                for (int i = 3; i <= (int)Math.sqrt(number); i += 2) {

                    if (number % i == 0) {
                        number++;
                        continue next_number;
                    }
                }
                primeSet.add(number);
                number++;
            }
        }
        return primeSet.stream().mapToLong(l -> l).toArray();
    }

    static void printTable(long[] prime, PrintWriter output) {

        int len = prime.length;
        BigInteger product = BigInteger.ONE;

        product = BigInteger.valueOf(prime[len - 1]).multiply(BigInteger.valueOf(prime[len - 1]));
        int numWidth = ("" + product).length();


        int cellWidth = numWidth + 2;
        String cellContent = "";

        // Print table header
        for (int h = -1; h < len; h++) {
            if (h == -1) {
                cellContent = String.format("%" + String.valueOf(cellWidth) + "s", " ");
                output.print(cellContent);
            } else {
                cellContent = String.format("%" + String.valueOf(cellWidth) + "d", prime[h]);
                output.print(cellContent);
            }
        }
        output.println();

        // Print table rows
        for (int i = 0; i < len; i++) {
            boolean needLeftMargin = true;

            for (int j = 0; j < len; j++) {

                if (needLeftMargin) {
                    cellContent = String.format("%" + String.valueOf(cellWidth) + "d", prime[i]);
                    output.print(cellContent);
                    needLeftMargin = false;
                }

                product = BigInteger.valueOf(prime[i]).multiply(BigInteger.valueOf(prime[j]));

                cellContent = String.format("%" + String.valueOf(cellWidth) + "d", product);
                output.print(cellContent);
            }
            output.println();
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out, true);

        long size = getInput(input, output);

        if (size != -1) {
            long[] primes = getPrimes(size);
            printTable(primes, output);
        }
    }
}
