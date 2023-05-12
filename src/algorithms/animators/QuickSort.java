package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/quick-sort/
public class QuickSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Quick Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        quickSort(matrix, player, array, 0, array.length - 1);

        player.reset();
    }

    private static void quickSort(Matrix matrix, SoundPlayer player, int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(matrix, player, array, low, high); // pi is partitioning index, arr[pi] is now at right place
            quickSort(matrix, player, array, low, pi - 1); // Recursively sort elements before partition and after partition
            quickSort(matrix, player, array, pi + 1, high); // Recursively sort elements before partition and after partition
        }
    }

    private static int partition(Matrix matrix, SoundPlayer player, int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) { // If current element is smaller than the pivot
            if (array[j] < pivot) { // increment index of smaller element
                i++;
                ArrayTools.swap(array, i, j); // swap arr[i] and arr[j]
                ArrayTools.arrayToMatrix(matrix, array); // update matrix
                player.playFromArray(array[i], array.length);
                Utils.sleep(25);
            }
        }
        ArrayTools.swap(array, i + 1, high); // swap arr[i+1] and arr[high] (or pivot)

        ArrayTools.arrayToMatrix(matrix, array); // update matrix
        player.playFromArray(array[i + 1], array.length);
        return i + 1;
    }
}
