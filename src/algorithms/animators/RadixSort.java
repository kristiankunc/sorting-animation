package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;

public class RadixSort {
    public static void animate(Matrix matrix) {
        int[] array = ArrayTools.matrixToArray(matrix);
        int max = ArrayTools.max(array);
        int maxDigits = ArrayTools.digits(max);

        for (int i = 0; i < maxDigits; i++) {
            Utils.sleep(900 / array.length);
            ArrayTools.arrayToMatrix(matrix, array);
            array = countingSort(matrix, array, i);
            ArrayTools.arrayToMatrix(matrix, array);
        }
    }

    private static int[] countingSort(Matrix matrix, int[] array, int digit) {
        int[] count = new int[10];
        int[] output = new int[array.length];

        for (int j : array) {
            count[ArrayTools.digitAt(j, digit)]++;
            ArrayTools.arrayToMatrix(matrix, array);
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            ArrayTools.arrayToMatrix(matrix, array);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int digitAt = ArrayTools.digitAt(array[i], digit);
            output[count[digitAt] - 1] = array[i];
            count[digitAt]--;
            ArrayTools.arrayToMatrix(matrix, array);
        }

        return output;
    }
}
