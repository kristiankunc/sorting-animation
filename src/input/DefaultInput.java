package input;

import algorithms.Algorithm;
import cz.gyarab.util.light.Matrix;
import lib.Animation;
import lib.ConsoleTools;

public class DefaultInput {
    public static void handle() {
        String[] algorithmNames = Algorithm.getNames();

        int actionIndex = -1;

        while (true) {
            switch (actionIndex) {
                case -1:
                    actionIndex = ConsoleTools.arrayPrompt("What would you like to do?", new String[]{
                            "Animate an algorithm",
                            "Get information about an algorithm",
                            "Exit"
                    });
                    break;

                case 0:
                    actionIndex = -1;
                    int algorithmIndex = ConsoleTools.arrayPrompt("Which algorithm would you like to animate?", algorithmNames);
                    Algorithm algorithm = Algorithm.getAlgorithms()[algorithmIndex];

                    Matrix matrix = Animation.setupMatrix();

                    Animation.animate(matrix, algorithm);
                    break;

                case 1:
                    actionIndex = -1;
                    algorithmIndex = ConsoleTools.arrayPrompt("Which algorithm would you like to get information about?", algorithmNames);
                    algorithm = Algorithm.getAlgorithms()[algorithmIndex];
                    ConsoleTools.clearConsole();
                    System.out.println(algorithm);
                    System.exit(0);
                case 2:
                    System.exit(0);

            }
        }
    }
}
