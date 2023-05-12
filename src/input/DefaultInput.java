package input;

import algorithms.Algorithm;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ConsoleTools;

public class DefaultInput {
    public static void handle() {
        String[] algorithmNames = Algorithm.getNames();

        int actionIndex = -1; // -1 = not selected (default), 0 = animate, 1 = get info, 2 = exit

        while (true) {
            switch (actionIndex) {
                case -1 -> { // not selected
                    actionIndex = ConsoleTools.arrayPrompt("What would you like to do?", new String[]{
                            "Animate an algorithm",
                            "Get information about an algorithm",
                            "Exit"
                    });
                }

                case 0 -> { // animate
                    actionIndex = -1;
                    int algorithmIndex = ConsoleTools.arrayPrompt("Which algorithm would you like to animate?", algorithmNames);
                    Algorithm algorithm = Algorithm.getAlgorithms()[algorithmIndex]; // get algorithm
                    boolean playSound = ConsoleTools.boolPrompt("Would you like to play a sound?"); // get play sound option

                    Matrix matrix = Animation.setupMatrix(); // setup matrix

                    Animation.animate(matrix, algorithm, playSound); // animate
                }

                case 1 -> { // get info
                    actionIndex = -1;
                    int algorithmIndex = ConsoleTools.arrayPrompt("Which algorithm would you like to get information about?", algorithmNames);
                    Algorithm algorithm =  Algorithm.getAlgorithms()[algorithmIndex]; // get algorithm

                    ConsoleTools.clearConsole();

                    System.out.println(algorithm); // print info
                    System.exit(0);
                }
                case 2 -> { // exit
                    System.out.println("Peace out!"); // print exit message
                    System.exit(0);
                }
            }
        }
    }
}
