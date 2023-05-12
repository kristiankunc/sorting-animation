package input;

import algorithms.Algorithm;
import cz.gyarab.util.light.Matrix;
import lib.Animation;

import java.util.Arrays;

public class CliInput {
    public static void handle(String[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].toLowerCase();
        }

        String action = args[0]; // get action

        switch (action) {
            case "animate" -> {
                checkAlgorithmArg(args); // check if algorithm arg is present

                String algorithmArg = args[1]; // get algorithm arg

                Algorithm algorithm = getAlgorithm(algorithmArg); // get algorithm

                if (algorithm == null) { // check if algorithm is valid
                    System.out.println("Invalid algorithm: " + algorithmArg);
                    System.exit(1);
                }

                int matrixSize = 50;
                boolean playSound = false;

                for (String arg : args) { // try to get matrix size from args, if not default to 50
                    if (arg.matches("--matrix-size=\\d+")) {
                        matrixSize = Integer.parseInt(arg.split("=")[1]);
                    } else if (arg.equals("--play-sound")) { // try to get play sound from args, if not default to false
                        playSound = true;
                    }
                }

                Matrix matrix = Matrix.createMatrix(matrixSize, matrixSize); // setup matrix
                Animation.animate(matrix, algorithm, playSound); // animate
                System.exit(0);
            }
            case "info" -> {
                checkAlgorithmArg(args);

                String algorithmArg = args[1]; // get algorithm arg

                Algorithm algorithm = getAlgorithm(algorithmArg); // get algorithm

                if (algorithm == null) { // check if algorithm is valid
                    System.out.println("Invalid algorithm: " + algorithmArg);
                    System.exit(1);
                }

                System.out.println(algorithm); // print info
                System.exit(0);
            }
            case "help" -> {
                String help = """

                        Actions:
                            animate <algorithm> [options] - animates the given algorithm
                            info <algorithm> - prints information about the given algorithm
                            help - prints this help message
                        Options:
                            --matrix-size=<size> - sets the size of the matrix, default is 50
                            --play-sound - plays a sound along with the animation, default is false
                        Algorithms:
                        """; // help message

                for (int i = 0; i < Algorithm.getAlgorithms().length; i++) { // add algorithms to help message
                    String spacing = " ".repeat(3 - String.valueOf(i + 1).length()); // calculate spacing
                    Algorithm algorithm = Algorithm.getAlgorithms()[i]; // get algorithm
                    help += spacing + (i + 1) + ". " + algorithm.prettyName + "\n"; // add algorithm to help message
                }

                help += """
                        To specify an algorithm you can use either the id of the algorithm or its name without spaces (bubblesort, shellsort, ...)
                        
                        Example usage:
                            java -jar main.jar animate 1 --matrix-size=100 --play-sound
                            java -jar main.jar info shellsort
                        """; // add example usage to help message

                System.out.println(help); // print help message

                System.exit(0);
            }
            default -> {
                System.out.println("Invalid action: " + action + " use help for help"); // print error message
                System.exit(1);
            }
        }
    }

    private static void checkAlgorithmArg(String[] args) { // check if algorithm arg is present
        if (args.length < 2) {
            System.out.println("Missing algorithm argument");
            System.exit(1);
        }
    }

    private static Algorithm getAlgorithm(String arg) { // get algorithm by arg (either id or name)
        if (arg.matches("\\d+")) { // if arg is a number, get by index
            int algorithmIndex = Integer.parseInt(arg);
            return Algorithm.getById(algorithmIndex - 1);

        } else { // else get by name
            return Algorithm.getByName(arg);
        }
    }
}
