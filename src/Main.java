import input.CliInput;
import input.DefaultInput;
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) { // If no arguments are passed, use the default input
            DefaultInput.handle();
        }

        CliInput.handle(args); // If arguments are passed, use the CLI input
    }
}