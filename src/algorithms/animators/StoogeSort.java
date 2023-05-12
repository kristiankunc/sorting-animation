package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/stooge-sort/

public class StoogeSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Stooge Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        stoogeSort(matrix, player, array, 0, array.length - 1); // sort the array

        player.reset();

    }

    private static void stoogeSort(Matrix matrix, SoundPlayer player, int[] array, int l, int h) {
        if (l >= h) {
            return;
        }

        if (array[l] > array[h]) { // swap if left element is greater than right element
            ArrayTools.swap(array, l, h);
            player.playFromArray(array[l], array.length);
            ArrayTools.arrayToMatrix(matrix, array); // update matrix
            Utils.sleep(2);
        }

        if (h - l + 1 > 2) { // if there are more than 2 elements
            int t = (h - l + 1) / 3; // find the third of the array
            stoogeSort(matrix, player, array, l, h - t); // sort the first 2/3 of the array
            stoogeSort(matrix, player, array, l + t, h); // sort the last 2/3 of the array
            stoogeSort(matrix, player, array, l, h - t); // sort the first 2/3 of the array again
        }
    }
}
