package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/shellsort/
public class ShellSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Shell Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        for (int gap = array.length / 2; gap > 0; gap /= 2) { // loop over gaps, gap means how many elements are between two compared elements
            for (int i = gap; i < array.length; i += 1) { // loop over elements
                int j;
                for (j = i; j >= gap && array[j - gap] >= array[i]; j -= gap) { // loop over elements in gap
                    array[j] = array[j - gap]; // move elements in gap
                }
                ArrayTools.swap(array, j, i);
                ArrayTools.arrayToMatrix(matrix, array); // update matrix
                player.playFromArray(array[j], array.length);
                Utils.sleep(25);
            }
        }

        player.reset();
    }
}
