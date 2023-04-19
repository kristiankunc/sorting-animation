package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ArrayTools;
import lib.MatrixTools;

public class MergeSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Merge Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        sort(matrix, 0, array.length - 1);
    }

    private static void sort(Matrix matrix, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(matrix, l, m);
            sort(matrix, m + 1, r);
            merge(matrix, l, m, r);
        }
    }

    private static void merge(Matrix matrix, int l, int m, int r) { // do not forget to apply the array to matrix on every change
        int[] array = ArrayTools.matrixToArray(matrix);
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(25);
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(25);
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(25);
        }
    }

}
