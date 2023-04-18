package lib;

import algorithms.Algorithm;
import cz.gyarab.util.Utils;
import cz.gyarab.util.light.LightColor;
import cz.gyarab.util.light.Matrix;

public class Animation {
    public static Matrix setupMatrix() {
        int size = 50;

        String sizeInput = ConsoleTools.stringPrompt("Enter the matrix size, default is 50/50, max is 100/100: ");
        if (!sizeInput.equals("")) {
            size = Integer.parseInt(sizeInput);
        }

        Matrix matrix = Matrix.createMatrix(size, size);
        matrix.showWindow();
        return matrix;
    }

    public static void animate(Matrix matrix, Algorithm algorithm) {
        countdown(matrix);

        ArrayTools.arrayToMatrix(matrix, ArrayTools.genRandomArray(matrix.getWidth()));

        switch (algorithm) {
            case BUBBLE_SORT -> bubbleSort(matrix);
            case BOGO_SORT -> bogoSort(matrix);
            case SELECTION_SORT -> selectionSort(matrix);
        }
    }

    private static void endAnimation(Matrix matrix) {
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
    private static void selectionSort(Matrix matrix) {
        matrix.setTitle("Selection Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayTools.swap(array, i, minIndex);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(1500 / array.length);

        }
        endAnimation(matrix);
    }
    private static void bubbleSort(Matrix matrix) {
        matrix.setTitle("Bubble Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayTools.swap(array, j, j + 1);
                }
                ArrayTools.arrayToMatrix(matrix, array);
                Utils.sleep((long) Math.sqrt(1000 / array.length));
            }
        }

        endAnimation(matrix);
    }

    private static void bogoSort(Matrix matrix) {
        matrix.setTitle("Bogo Sort");
        int[] array = ArrayTools.matrixToArray(matrix);

        while (!ArrayTools.isSorted(array)) {
            array = ArrayTools.genRandomArray(array.length);
            ArrayTools.arrayToMatrix(matrix, array);
            Utils.sleep(1);
        }

        endAnimation(matrix);
    }
}
