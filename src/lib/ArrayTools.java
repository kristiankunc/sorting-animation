package lib;

import cz.gyarab.util.light.LightColor;
import cz.gyarab.util.light.Matrix;

public class ArrayTools {
    private static int[] lastAppliedArray = null;
    public static int[] genRandomArray(int length) { // random array with no duplicate values, there is no 0, lowest val is 1
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) { // fill array with values 1 to length
            array[i] = i + 1;
        }
        for (int i = 0; i < array.length; i++) { // shuffle array
            int randomIndex = (int) (Math.random() * array.length); // random index from 0 to length
            int temp = array[i]; // swap values
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return array;
    }
    public static int[] matrixToArray(Matrix matrix) { // convert the height of each row in a matrix to an array
        int[] array = new int[matrix.getWidth()];
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.isOn(i, j)) {
                    array[i] = j + 1; // add 1 to the value because the lowest value is 1
                }
            }
        }
        return array;
    }

    public static void arrayToMatrix(Matrix matrix, int[] array) { // convert an array to the height of each row in a matrix
        if (lastAppliedArray == null) { // if this is the first time the array is being applied, set lastAppliedArray to the array
            lastAppliedArray = array.clone();
        }

        for (int i = 0; i < matrix.getWidth(); i++) { // apply the array to the matrix
            LightColor color = LightColor.BLUE;

            if (array[i] != lastAppliedArray[i]) {
                color = LightColor.RED;
            }
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (j < array[i]) { // if the height is less than the value of the array at the index, turn on the light
                    matrix.setColor(i, j, color); // set the color of the light
                } else {
                    matrix.setOff(i, j);
                }
            }
        }
        lastAppliedArray = array.clone(); // set lastAppliedArray to the array
    }

    public static boolean isSorted(int[] array) { // check if an array is sorted
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] array, int index1, int index2) { // swap two values in an array
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
