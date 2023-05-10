package lib;


import cz.gyarab.util.Utils;

import java.util.Scanner;

public class ConsoleTools {
    private static int retryInt(String prompt, int min, int max) { // Retries the int prompt
        System.out.print("Invalid input, try again: ");
        Utils.sleep(650);
        return intPrompt(prompt, min, max);
    }

    private static int retryArray(String prompt, String[] array) { // Retries the array prompt
        System.out.print("Invalid input, try again: ");
        Utils.sleep(650);
        return arrayPrompt(prompt, array);
    }
    public static void clearConsole() { // Clears the console (does NOT work in built-in terminal in IntelliJ IDEA, use the external terminal)
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            try {
                // https://stackoverflow.com/a/32295974/14762088
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            // https://stackoverflow.com/a/32295974/14762088
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static int intPrompt(String prompt, int min, int max) { // Prompts the user for an int
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);

        try { // Tries to get the input
            int input = scanner.nextInt();

            if (input < min || input > max) {
                return retryInt(prompt, min, max);
            }

            return input;
        }
        catch (Exception e) { // If the input is invalid, retry
            return retryInt(prompt, min, max);
        }
    }

    public static boolean boolPrompt(String prompt) { // Prompts the user for a boolean
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public static int arrayPrompt(String prompt, String[] array) { // Prompts the user for an element from an array
        clearConsole();
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) { // Prints the array with first index being 1
            System.out.println((i + 1) + ": " + array[i]);
        }
        System.out.print("Enter a number: ");

        try { // Tries to get the input
            int input = scanner.nextInt();

            if (input < 1 || input > array.length) {
                return retryArray(prompt, array);
            }

            return input - 1;
        }
        catch (Exception e) { // If the input is invalid, retry
            return retryArray(prompt, array);
        }
    }
}
