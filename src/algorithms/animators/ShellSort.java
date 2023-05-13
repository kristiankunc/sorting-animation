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

        for (int gap = array.length / 2; gap > 0; gap /= 2) { // Start with a big gap, then reduce the gap
            for (int i = gap; i < array.length; i += 1) { // Do a gapped insertion sort for this gap size.
                int temp = array[i]; // Save array[i] in temp and make a hole at position i
                int j; // Shift earlier gap-sorted elements up until the correct location for array[i] is found
                for (j = i; j >= gap && array[j - gap] >= temp; j -= gap) { // j -= gap is the same as j = j - gap
                    array[j] = array[j - gap]; // Put temp (the original array[i]) into its correct location
                }
                array[j] = temp; // Put temp (the original array[i]) into its correct location

                ArrayTools.arrayToMatrix(matrix, array); // Render the array
                player.playFromArray(array[j], array.length);
                Utils.sleep(25);
            }
        }

        player.reset();
    }
}