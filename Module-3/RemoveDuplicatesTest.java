import java.util.ArrayList;
import java.util.Random;

/**
 * Name: Elvia Gisella Adair
 * Date: April 12 2026
 * Assignment: Remove Duplicates from ArrayList
 */
public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();


        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original List:");
        System.out.println(originalList);

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(uniqueList);
    }

    /**
     * Removes duplicate elements from an ArrayList.
     *
     * @param list the original ArrayList
     * @param <E> the type of elements in the list
     * @return a new ArrayList with duplicates removed
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}