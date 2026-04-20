
/**
 * Name: Elvia Gisella Adair
 * Date: April 19 2026
 * Assignment: Module 5.2 Word Processor
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

public class WordProcessor {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\gisel\\csd-420\\module-5\\collection_of_words.txt";

        try {
            Set<String> words = readWordsFromFile(fileName);

            System.out.println("Words in Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("\nWords in Descending Order:");
            for (String word : ((TreeSet<String>) words).descendingSet()) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    // Method to read words and remove duplicates
    public static Set<String> readWordsFromFile(String fileName) throws FileNotFoundException {
        Set<String> wordSet = new TreeSet<>(); // automatically sorts + removes duplicates
        Scanner input = new Scanner(new File(fileName));

        while (input.hasNext()) {
            String word = input.next().toLowerCase().replaceAll("[^a-z]", "");
            if (!word.isEmpty()) {
                wordSet.add(word);
            }
        }

        input.close();
        return wordSet;
    }
}