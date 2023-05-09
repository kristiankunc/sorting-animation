package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/shellsort/
public class ShellSort {
    public static void animate(Matrix matrix) {
        matrix.setTitle("Shell Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer();

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] >= temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
                ArrayTools.arrayToMatrix(matrix, array);
                player.playFromArray(array[j], array.length);
                Utils.sleep(25);
            }
        }

        player.reset();
    }
}
