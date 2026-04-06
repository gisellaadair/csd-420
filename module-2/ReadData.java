/*
 * Name: Elvia Gisella Adair
 * Date: April 5th 2026
 * Assignment: Module 2.2 Binary I/O and Recursion
 * Course: CSD-420 Advance Java Programming
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) {
        try {
            File file = new File("GisellaAdair_datafile.dat");
            Scanner input = new Scanner(file);

            System.out.println("Reading data from file:\n");

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}