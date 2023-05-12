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

        sort(matrix, player, 0, array.length - 1); // sort the array

        player.reset();
    }

    private static void sort(Matrix matrix, SoundPlayer player, int l, int r) {
        if (l < r) { // if there is more than one element
            int m = (l + r) / 2; // find the middle
            sort(matrix, player, l, m); // sort the left side
            sort(matrix, player, m + 1, r); // sort the right side
            merge(matrix, player, l, m, r); // merge the two sides
        }
    }

    private static void merge(Matrix matrix, SoundPlayer player, int l, int m, int r) { // do not forget to apply the array to matrix on every change
        int[] array = ArrayTools.matrixToArray(matrix);
        int n1 = m - l + 1; // size of the left side
        int n2 = r - m; // size of the right side

        int[] L = new int[n1]; // create the left side
        int[] R = new int[n2]; // create the right side

        System.arraycopy(array, l, L, 0, n1); // copy the left side
        for (int j = 0; j < n2; ++j) // copy the right side
            R[j] = array[m + 1 + j];

        int i = 0, j = 0; // indexes for the left and right side
        int k = l; // index for the array
        while (i < n1 && j < n2) { // while there are elements in both sides
            if (L[i] <= R[j]) {
                array[k] = L[i]; // if the left side is smaller
                i++;
            } else { // if the right side is smaller
                array[k] = R[j]; // if the right side is smaller
                j++;
            }
            k++;
            player.playFromArray(array[k - 1], array.length);
            ArrayTools.arrayToMatrix(matrix, array); // apply the array to matrix
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
