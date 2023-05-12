package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/bubble-sort/
public class BubbleSort {

    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Bubble Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        for (int i = 0; i < array.length; i++) { // loop through all elements
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) { // if the previous element is bigger than the current element, swap them
                    ArrayTools.swap(array, j - 1, j);
                    player.playFromArray(array[j - 1], array.length);
                }
                ArrayTools.arrayToMatrix(matrix, array); // update the matrix
                Utils.sleep(10);
            }
        }
        player.reset();
    }
}
