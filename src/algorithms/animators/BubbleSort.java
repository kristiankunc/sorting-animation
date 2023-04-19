package algorithms.animators;

import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ArrayTools;

public class BubbleSort {

    public static void animate(Matrix matrix) { // animate the bubble sort algorithm, dont forget to apply all changes to the matrix
        matrix.setTitle("Bubble Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    ArrayTools.swap(array, j - 1, j);
                }
                ArrayTools.arrayToMatrix(matrix, array);
            }
        }
    }
}
