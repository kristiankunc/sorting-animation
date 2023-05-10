package algorithms.animators;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;
import lib.ArrayTools;
import lib.SoundPlayer;

// https://www.geeksforgeeks.org/heap-sort/
public class HeapSort {
    public static void animate(Matrix matrix, boolean playSound) {
        matrix.setTitle("Heap Sort");
        int[] array = ArrayTools.matrixToArray(matrix);
        SoundPlayer player = new SoundPlayer(playSound);

        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            Utils.sleep(15);
            heapify(matrix, player, array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            ArrayTools.swap(array, 0, i);
            ArrayTools.arrayToMatrix(matrix, array);
            player.playFromArray(array[i], array.length);
            Utils.sleep(30);
            heapify(matrix, player, array, i, 0);
        }

        player.reset();
    }
    private static void heapify(Matrix matrix, SoundPlayer player, int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            ArrayTools.swap(array, i, largest);
            ArrayTools.arrayToMatrix(matrix, array);
            player.playFromArray(array[i], array.length);
            Utils.sleep(30);
            heapify(matrix, player, array, n, largest);
        }
    }
}
