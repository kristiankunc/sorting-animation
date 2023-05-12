package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.codingeek.com/algorithms/counting-sort-explanation-pseudocode-and-implementation/
public class CountingSort {

    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Counting Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        int[] sorted = new int[array.length]; // output array
        int[] count = new int[matrix.getWidth() + 1]; // count array
        for (int j : array) { // fill count array
            count[j]++;
        }
        for (int i = 1; i < count.length; i++) { // modify count array
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) { // fill sorted array
            sorted[count[array[i]] - 1] = array[i]; // -1 because of 0 indexing
            count[array[i]]--;  // decrement count
            ArrayTools.arrayToMatrix(matrix, sorted); // update matrix
            player.playFromArray(sorted[i], sorted.length);
            Utils.sleep(50);
        }

        player.reset();
    }
}
