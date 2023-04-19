package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ArrayTools;

public class QuickSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Quick Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        quickSort(matrix, array, 0, array.length - 1);
    }

    private static void quickSort(Matrix matrix, int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(matrix, array, low, high);
            quickSort(matrix, array, low, pi - 1);
            quickSort(matrix, array, pi + 1, high);
        }
    }

    private static int partition(Matrix matrix, int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            Utils.sleep(20);
            ArrayTools.arrayToMatrix(matrix, array);
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        ArrayTools.arrayToMatrix(matrix, array);
        return i + 1;
    }
}
