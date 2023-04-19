package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ArrayTools;

public class InsertionSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Insertion Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(60);
        }
    }
}
