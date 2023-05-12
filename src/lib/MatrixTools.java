package lib;

import cz.gyarab.util.light.LightColor;
import cz.gyarab.util.light.Matrix;

import java.awt.*;

public class MatrixTools {
    public static final int[] sevenSegmentNumbers = {0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011, 0b1011011, 0b1011111, 0b1110000, 0b1111111, 0b1111011};

    public static void clearMatrix(Matrix matrix) { // Turns off all the lights in the matrix
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                matrix.setOff(i, j);
            }
        }
    }

    public static void renderNumber(Matrix matrix, int number) { // Renders a number on the matrix
        clearMatrix(matrix);

        int numberToRender = sevenSegmentNumbers[number];
        
         // checks if nth bit is 1 to render the corresponding segment
        if ((numberToRender & 0b1000000) == 0b1000000) {
            for (int i = 0; i < matrix.getWidth(); i++) {
                matrix.setOn(i, matrix.getHeight() - 1);
            }
        }

        if ((numberToRender & 0b0100000) == 0b0100000) {
            for (int i = 0; i < matrix.getHeight() / 2; i++) {
                matrix.setOn(matrix.getWidth() - 1, i + matrix.getHeight() / 2);
            }
        }

        if ((numberToRender & 0b0010000) == 0b0010000) {
            for (int i = 0; i < matrix.getHeight() / 2; i++) {
                matrix.setOn(matrix.getWidth() - 1, i);
            }
        }

        if ((numberToRender & 0b0001000) == 0b0001000) {
            for (int i = 0; i < matrix.getWidth(); i++) {
                matrix.setOn(i, 0);
            }
        }

        if ((numberToRender & 0b0000100) == 0b0000100) {
            for (int i = 0; i < matrix.getHeight() / 2; i++) {
                matrix.setOn(0, i);
            }
        }

        if ((numberToRender & 0b0000010) == 0b0000010) {
            for (int i = 0; i < matrix.getHeight() / 2; i++) {
                matrix.setOn(0, i + matrix.getHeight() / 2);
            }
        }

        if ((numberToRender & 0b0000001) == 0b0000001) {
            for (int i = 0; i < matrix.getWidth(); i++) {
                matrix.setOn(i, matrix.getHeight() / 2);
            }
        }
    }

    public static void resetColor(Matrix matrix) { // Resets the color of the matrix to blue
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.isOn(i, j)) {
                    matrix.setColor(i, j, LightColor.BLUE);
                }
            }
        }
    }
}
