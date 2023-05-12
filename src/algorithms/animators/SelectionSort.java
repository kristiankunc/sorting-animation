package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/selection-sort/

public class SelectionSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Selection Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        for (int i = 0; i < array.length; i++) { // One by one move boundary of unsorted subarray
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) { // Find the minimum element in unsorted array
                if (array[j] < array[minIndex]) { // If the found minimum element is smaller than the first element
                    minIndex = j;
                }
            }
            ArrayTools.swap(array, i, minIndex); // Swap the found minimum element with the first element
            ArrayTools.arrayToMatrix(matrix, array);
            player.playFromArray(array[i], array.length);
            Utils.sleep(50);
        }

        player.reset();
    }
}
