package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;

// https://www.geeksforgeeks.org/stooge-sort/

public class StoogeSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Stooge Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        stoogeSort(matrix, array, 0, array.length - 1);
        ArrayTools.arrayToMatrix(matrix, array);
    }

    private static void stoogeSort(Matrix matrix, int[] array, int l, int h) {
        if (l >= h) {
            return;
        }

        if (array[l] > array[h]) {
            ArrayTools.swap(array, l, h);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(20);
        }

        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSort(matrix, array, l, h - t);
            stoogeSort(matrix, array, l + t, h);
            stoogeSort(matrix, array, l, h - t);
        }
    }
}
