package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;

// https://www.codingeek.com/algorithms/counting-sort-explanation-pseudocode-and-implementation/
public class CountingSort {

    public static void animate(Matrix matrix) {
        int[] array = ArrayTools.matrixToArray(matrix);
        sort(matrix, array);
    }

    public static void sort(Matrix matrix, int[] array) {
        int[] sorted = new int[array.length];
        int[] count = new int[200 + 1];
        for (int j : array) {
            count[j]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            sorted[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            ArrayTools.arrayToMatrix(matrix, sorted);
            Utils.sleep(15);
        }
    }
}
