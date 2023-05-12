package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/insertion-sort/
public class InsertionSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Insertion Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        for (int i = 1; i < array.length; i++) { // loop through array
            int key = array[i]; // key is the current element
            int j = i - 1; // j is the index of the element before the current element

            while (j >= 0 && array[j] > key) { // loop through sorted part of array
                array[j + 1] = array[j]; // move elements to the right
                j--; // move to the left
            }
            array[j + 1] = key; // insert key to the right place
            player.playFromArray(array[j + 1], array.length);
            ArrayTools.arrayToMatrix(matrix, array); // update matrix
            Utils.sleep(60);
        }

        player.reset();
    }
}
