/*
 * Name: Elvia Gisella Adair
 * Date: April 5th 2026
 * Assignment: Module 2.2 Binary I/O and Recursion
 * Course: CSD-420 Advance Java Programming
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100);
        }

        for (int i = 0; i < 5; i++) {
            doubleArray[i] = rand.nextDouble() * 100;
        }

        try {
            PrintWriter out = new PrintWriter(new FileWriter("GisellaAdair_datafile.dat", true));

            out.println("Integers:");
            for (int num : intArray) {
                out.print(num + " ");
            }

            out.println("\nDoubles:");
            for (double num : doubleArray) {
                out.print(String.format("%.2f ", num));
            }

            out.println("\n----------------------");

            out.close();

            System.out.println("Data successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}