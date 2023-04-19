package lib;

import algorithms.Algorithm;
import algorithms.animators.*;
import cz.gyarab.util.Utils;
import cz.gyarab.util.light.LightColor;
import cz.gyarab.util.light.Matrix;

public class Animation {
    public static Matrix setupMatrix() {
        int size = 50;

        String sizeInput = ConsoleTools.stringPrompt("Enter the matrix size, default is 50, max is 200: ");
        if (!sizeInput.equals("")) {
            size = Integer.parseInt(sizeInput);
        }

        if (size > 200) {
            size = 200;
        }

        Matrix matrix = Matrix.createMatrix(size, size);
        matrix.showWindow();
        return matrix;
    }

    public static void animate(Matrix matrix, Algorithm algorithm) {
        countdown(matrix);

        ArrayTools.arrayToMatrix(matrix, ArrayTools.genRandomArray(matrix.getWidth()));

        switch (algorithm) {
            case BUBBLE_SORT -> BubbleSort.animate(matrix);
            case BOGO_SORT -> BogoSort.animate(matrix);
            case SELECTION_SORT -> SelectionSort.animate(matrix);
            case INSERTION_SORT -> InsertionSort.animate(matrix);
            case MERGE_SORT -> MergeSort.animate(matrix);
            case QUICK_SORT -> QuickSort.animate(matrix);
            case HEAP_SORT -> HeapSort.animate(matrix);
            case COUNTING_SORT -> CountingSort.animate(matrix);
            case SHELL_SORT -> ShellSort.animate(matrix);
            case STOOGE_SORT -> StoogeSort.animate(matrix);
        }

        endAnimation(matrix);
    }

    public static void endAnimation(Matrix matrix) {
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.isOn(i, j)) {
                    matrix.setColor(i, j, LightColor.GREEN);
                }
            }
            Utils.sleep(10);
        }

        Utils.sleep(1500);

        matrix.hideWindow();
    }

    private static void countdown(Matrix matrix) {
        for (int i = 3; i > 0; i--) {
            switch (i) {
                case 3 -> {
                    matrix.setTitle("3");
                    matrix.setColor(LightColor.RED);
                }
                case 2 -> {
                    matrix.setTitle("2");
                    matrix.setColor(LightColor.ORANGE);
                }
                case 1 -> {
                    matrix.setTitle("1");
                    matrix.setColor(LightColor.GREEN);
                }
            }

            MatrixTools.renderNumber(matrix, i);
            Utils.sleep(1000);
        }

        matrix.setColor(LightColor.BLUE);
        MatrixTools.clearMatrix(matrix);

    }
}
