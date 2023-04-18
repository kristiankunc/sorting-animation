package algorithms;
public enum Algorithm {
    SELECTION_SORT("Selection Sort",
    "Selection sort works by finding the smallest element in the array and swapping it with the first element. " +
            "Then it finds the second smallest element and swaps it with the second element. " +
            "It continues doing this until the entire array is sorted.",
            Complexity.N_SQUARED,
            Complexity.N_SQUARED,
            Complexity.N_SQUARED,
            Complexity.ONE,
            true),
    BUBBLE_SORT("Bubble Sort",
            "Bubble sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.",
            Complexity.N,
            Complexity.N_SQUARED,
            Complexity.N_SQUARED,
            Complexity.ONE,
            true),

    BOGO_SORT("Bogo Sort",
            "Bogo sort is a highly inefficient sorting algorithm based on the generate and test paradigm. The algorithm successively generates permutations of its input until it finds one that is sorted.",
            Complexity.N,
            Complexity.N_PLUS_ONE_FACT,
            Complexity.INFINITY,
            Complexity.ONE,
            false);

    // Bubble sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
    public final String prettyName;
    public final String description;
    public final Complexity bestCase;
    public final Complexity averageCase;
    public final Complexity worstCase;
    public final Complexity spaceComplexity;
    public final boolean isStable;

    Algorithm(String name, String description, Complexity bestCase, Complexity averageCase, Complexity worstCase, Complexity spaceComplexity, boolean isStable) {
        this.prettyName = name;
        this.description = description;
        this.bestCase = bestCase;
        this.averageCase = averageCase;
        this.worstCase = worstCase;
        this.spaceComplexity = spaceComplexity;
        this.isStable = isStable;
    }

    @Override
    public String toString() {
        return description + "\n"
                + "Time complexity:" + "\n"
                + "Best case: " + bestCase.emoji + " " + bestCase.prettyName  + "\n"
                + "Average case: " + averageCase.emoji + " " + averageCase.prettyName  + "\n"
                + "Worst case: " + worstCase.emoji + " " + worstCase.prettyName  + "\n"
                + "Space complexity: " + spaceComplexity.emoji + " " + spaceComplexity.prettyName  + "\n"
                + "Stable: " + isStable;
    }

    public static String[] getNames() {
        String[] names = new String[Algorithm.values().length];
        for (int i = 0; i < Algorithm.values().length; i++) {
            names[i] = Algorithm.values()[i].prettyName;
        }
        return names;
    }

    public static Algorithm[] getAlgorithms() {
        return Algorithm.values();
    }
}
