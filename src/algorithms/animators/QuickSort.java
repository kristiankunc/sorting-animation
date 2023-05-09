package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/quick-sort/
public class QuickSort {
    public static void animate(Matrix matrix) {
        // TODO: Fix this
        matrix.setTitle("Quick Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer();

        quickSort(matrix, player, array, 0, array.length - 1);

        player.reset();
    }

    private static void quickSort(Matrix matrix, SoundPlayer player, int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(matrix, player, array, low, high);
            quickSort(matrix, player, array, low, pi - 1);
            quickSort(matrix, player, array, pi + 1, high);
        }
    }

    private static int partition(Matrix matrix, SoundPlayer player, int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            ArrayTools.arrayToMatrix(matrix, array);
            player.playFromArray(array[j], array.length);
            Utils.sleep(20);
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        ArrayTools.arrayToMatrix(matrix, array);
        player.playFromArray(array[i + 1], array.length);
        return i + 1;
    }
}
