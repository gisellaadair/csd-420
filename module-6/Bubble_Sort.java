import java.util.Comparator;
import java.util.Arrays;

/**
 * Name: Elvia Gisella Adair
 * Date: April 26 2026
 * Assignment: Module 6.2 Bubble Sort Method
/** */
public class Bubble_Sort {
    public static <T extends Comparable<T>> void bubbleSort(T[] list) {
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Swap elements
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static <T> void bubbleSort(T[] list, Comparator<T> comparator) {
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        Integer[] numbers = {5, 2, 9, 1, 3};
        System.out.println("Before sorting (Comparable): " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("After sorting (Comparable):  " + Arrays.toString(numbers));

        String[] words = {"banana", "apple", "cherry"};
        System.out.println("\nBefore sorting (Comparable Strings): " + Arrays.toString(words));

        bubbleSort(words);

        System.out.println("After sorting (Comparable Strings):  " + Arrays.toString(words));

        Integer[] numbersDesc = {5, 2, 9, 1, 3};
        System.out.println("\nBefore sorting (Comparator Desc): " + Arrays.toString(numbersDesc));

        bubbleSort(numbersDesc, (a, b) -> b - a);

        System.out.println("After sorting (Comparator Desc):  " + Arrays.toString(numbersDesc));

        String[] wordsByLength = {"banana", "kiwi", "apple", "fig"};
        System.out.println("\nBefore sorting (Comparator Length): " + Arrays.toString(wordsByLength));

        bubbleSort(wordsByLength, (a, b) -> a.length() - b.length());

        System.out.println("After sorting (Comparator Length):  " + Arrays.toString(wordsByLength));
    }
}