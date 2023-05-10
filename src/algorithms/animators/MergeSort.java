package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/merge-sort/
public class MergeSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Merge Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        sort(matrix, player, 0, array.length - 1);

        player.reset();
    }

    private static void sort(Matrix matrix, SoundPlayer player, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(matrix, player, l, m);
            sort(matrix, player, m + 1, r);
            merge(matrix, player, l, m, r);
        }
    }

    private static void merge(Matrix matrix, SoundPlayer player, int l, int m, int r) { // do not forget to apply the array to matrix on every change
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
            player.playFromArray(array[k - 1], array.length);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(25);
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            player.playFromArray(array[k - 1], array.length);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(25);
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            player.playFromArray(array[k - 1], array.length);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(25);
        }
    }

}
