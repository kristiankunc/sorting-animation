package lib;

import cz.gyarab.util.light.Matrix;
public class ArrayTools {
    public static int[] genRandomArray(int length) { // random array with no duplicate values, there is no 0, lowest val is 1
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < array.length; i++) {
            int randomIndex = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return array;
    }
    public static int[] matrixToArray(Matrix matrix) { // convert the height of each row to an array
        int[] array = new int[matrix.getWidth()];
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.isOn(i, j)) {
                    array[i] = j + 1;
                }
            }
        }
        return array;
    }

    public static void arrayToMatrix(Matrix matrix, int[] array) { // convert an array to the height of each row
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (j < array[i]) {
                    matrix.setOn(i, j);
                } else {
                    matrix.setOff(i, j);
                }
            }
        }
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

    public static int max(int[] array) { // find the max value in an array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int digits(int number) { // find the number of digits in a number
        int digits = 0;
        while (number > 0) {
            number /= 10;
            digits++;
        }
        return digits;
    }

    public static int digitAt(int number, int digit) { // find the digit at a specific index in a number
        for (int i = 0; i < digit; i++) {
            number /= 10;
        }
        return number % 10;
    }
}
