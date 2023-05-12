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
        for (int i = n / 2 - 1; i >= 0; i--) { // Build heap (rearrange array)
            Utils.sleep(15);
            heapify(matrix, player, array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) { // One by one extract an element from heap
            ArrayTools.swap(array, 0, i);
            ArrayTools.arrayToMatrix(matrix, array); // append to matrix
            player.playFromArray(array[i], array.length);
            Utils.sleep(30);
            heapify(matrix, player, array, i, 0); // call max heapify on the reduced heap
        }

        player.reset();
    }
    private static void heapify(Matrix matrix, SoundPlayer player, int[] array, int n, int i) { // To heapify a subtree rooted with node i which is an index in array[]. n is size of heap
        int largest = i;
        int l = 2 * i + 1; // l - left
        int r = 2 * i + 2; // r - right

        if (l < n && array[l] > array[largest]) { // If left child is larger than root
            largest = l;
        }
        if (r < n && array[r] > array[largest]) { // If right child is larger than largest so far
            largest = r;
        }
        if (largest != i) { // If largest is not root
            ArrayTools.swap(array, i, largest); // swap
            ArrayTools.arrayToMatrix(matrix, array); // append to matrix
            player.playFromArray(array[i], array.length);
            Utils.sleep(30);
            heapify(matrix, player, array, n, largest); // Recursively heapify the affected sub-tree
        }
    }
}
