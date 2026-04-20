import java.util.LinkedList;
import java.util.Iterator;

/**
 * Name: Elvia Gisella Adair
 * Date: April 12 2026
 * Assignment: Linked List
 */

public class LinkedListPerformance{

    public static void main(String[] args) {

        int[] testSizes = {50_000, 500_000};

        for (int size : testSizes) {
            System.out.println("\n==============================");
            System.out.println("Testing LinkedList with " + size + " elements");
            System.out.println("==============================");

            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                list.add(i);
            }
            if (list.size() != size) {
                System.out.println("Error: List size mismatch!");
            } else {
                System.out.println("List populated correctly.");
            }
            long startIterator = System.nanoTime();

            long sum1 = 0;
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sum1 += it.next();
            }

            long endIterator = System.nanoTime();

            long iteratorTime = endIterator - startIterator;

            long startGet = System.nanoTime();

            long sum2 = 0;
            for (int i = 0; i < list.size(); i++) {
                sum2 += list.get(i);
            }

            long endGet = System.nanoTime();

            long getTime = endGet - startGet;

            if (sum1 != sum2) {
                System.out.println("Warning: Traversal results do not match!");
            }

            System.out.println("Iterator traversal time: " + iteratorTime / 1_000_000.0 + " ms");
            System.out.println("get(index) traversal time: " + getTime / 1_000_000.0 + " ms");
        }
    }
}