package lib;

import algorithms.Algorithm;
import algorithms.animators.*;
import cz.gyarab.util.Utils;
import cz.gyarab.util.light.LightColor;
import cz.gyarab.util.light.Matrix;

public class Animation {
    public static Matrix setupMatrix() { // Prompts the user for the matrix size and creates a matrix
        int size = ConsoleTools.intPrompt("Enter the matrix size, recommended is 50, max is 200:", 1, 200);

        return Matrix.createMatrix(size, size);
    }

    public static void animate(Matrix matrix, Algorithm algorithm, boolean playSound) { // Animates the given algorithm
        matrix.showWindow();

        countdown(matrix);

        ArrayTools.arrayToMatrix(matrix, ArrayTools.genRandomArray(matrix.getWidth())); // Generates a random array and displays it

        switch (algorithm) { // animate the algorithm by calling the correct animator
            case BUBBLE_SORT -> BubbleSort.animate(matrix, playSound);
            case BOGO_SORT -> BogoSort.animate(matrix, playSound);
            case SELECTION_SORT -> SelectionSort.animate(matrix, playSound);
            case INSERTION_SORT -> InsertionSort.animate(matrix, playSound);
            case MERGE_SORT -> MergeSort.animate(matrix, playSound);
            case QUICK_SORT -> QuickSort.animate(matrix, playSound);
            case HEAP_SORT -> HeapSort.animate(matrix, playSound);
            case COUNTING_SORT -> CountingSort.animate(matrix, playSound);
            case SHELL_SORT -> ShellSort.animate(matrix, playSound);
            case STOOGE_SORT -> StoogeSort.animate(matrix, playSound);
        }

        endAnimation(matrix, playSound);
    }

    public static void endAnimation(Matrix matrix, boolean playSound) { // Ends the animation with an ending animation
        MatrixTools.resetColor(matrix);

        SoundPlayer player = new SoundPlayer(playSound);
        player.reset(); // not needed (?) but just to be sure


        for (int i = 0; i < matrix.getWidth(); i++) { // make the matrix green, slowly
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.isOn(i, j)) {
                    matrix.setColor(i, j, LightColor.GREEN);
                }
            }
            Utils.sleep(10);
            player.playFromArray(i, matrix.getWidth());
        }

        player.reset();

        Utils.sleep(1500);

        matrix.hideWindow();
    }

    private static void countdown(Matrix matrix) { // Counts down from 3 to 1 (seven segment display)
        for (int i = 3; i > 0; i--) {
            switch (i) {
                case 3 -> {
                    matrix.setColor(LightColor.RED);
                }
                case 2 -> {
                    matrix.setColor(LightColor.ORANGE);
                }
                case 1 -> {
                    matrix.setColor(LightColor.GREEN);
                }
            }

            matrix.setTitle(String.valueOf(i));
            MatrixTools.renderNumber(matrix, i);
            Utils.sleep(1000);
        }

        matrix.setColor(LightColor.BLUE);
        MatrixTools.clearMatrix(matrix);

    }
}
