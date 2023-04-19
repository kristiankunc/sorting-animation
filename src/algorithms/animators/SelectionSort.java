package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ArrayTools;


public class SelectionSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Selection Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayTools.swap(array, i, minIndex);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(1500 / array.length);

        }
    }
}
