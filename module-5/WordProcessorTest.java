/**
 * Name: Elvia Gisella Adair
 * Date: April 19 2026
 * Assignment: Module 5.2 Word Processor
 */
import java.io.FileNotFoundException;
import java.util.Set;

public class WordProcessorTest {

    public static void main(String[] args) {
        try {
            Set<String> words = WordProcessor.readWordsFromFile("C:\\Users\\gisel\\csd-420\\module-5\\collection_of_words.txt");

            // Test 1: Ensure no duplicates (Set should handle this)
            System.out.println("Test 1 - No duplicates:");
            System.out.println("Total unique words: " + words.size());

            // Test 2: Ensure ascending order
            System.out.println("\nTest 2 - Ascending order:");
            String previous = "";
            for (String word : words) {
                if (word.compareTo(previous) < 0) {
                    System.out.println("Error: Not sorted correctly!");
                }
                previous = word;
            }
            System.out.println("Ascending order verified.");

            // Test 3: Ensure descending order
            System.out.println("\nTest 3 - Descending order:");
            String last = "";
            for (String word : ((java.util.TreeSet<String>) words).descendingSet()) {
                if (!last.equals("") && word.compareTo(last) > 0) {
                    System.out.println("Error: Not sorted correctly!");
                }
                last = word;
            }
            System.out.println("Descending order verified.");

        } catch (FileNotFoundException e) {
            System.out.println("Test failed: File not found.");
        }
    }
}