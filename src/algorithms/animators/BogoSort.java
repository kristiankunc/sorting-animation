package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;

// https://www.geeksforgeeks.org/bogosort-permutation-sort/
public class BogoSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Bogo Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        while (!ArrayTools.isSorted(array)) {
            array = ArrayTools.genRandomArray(array.length);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(1);
        }
    }
}
