package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/bogosort-permutation-sort/
public class BogoSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Bogo Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        while (!ArrayTools.isSorted(array)) { // while array is not sorted
            array = ArrayTools.genRandomArray(array.length); // shuffle array
            ArrayTools.arrayToMatrix(matrix, array); // update matrix
            player.playFromArray(array[0], array.length);
            Utils.sleep(1);
        }

        player.reset();
    }
}
