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
            false),

    INSERTION_SORT("Insertion Sort",
            "Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. " +
                    "It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.",
            Complexity.N,
            Complexity.N_SQUARED,
            Complexity.N_SQUARED,
            Complexity.ONE,
            true),

    MERGE_SORT("Merge Sort",
            "Merge sort is an efficient, general-purpose, comparison-based sorting algorithm. " +
                    "Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output.",
            Complexity.N_LOG_N,
            Complexity.N_LOG_N,
            Complexity.N_LOG_N,
            Complexity.N,
            true),

    QUICK_SORT("Quick Sort",
            "Quick sort is a divide and conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, " +
                    "according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. " +
                    "This can be done in-place, requiring small additional amounts of memory to perform the sorting.",
            Complexity.N_LOG_N,
            Complexity.N_LOG_N,
            Complexity.N_SQUARED,
            Complexity.LOG_N,
            false),

    HEAP_SORT("Heap Sort",
            "Heap sort is a comparison-based sorting algorithm. " +
                    "Heapsort can be thought of as an improved selection sort: like that algorithm, it divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region. " +
                    "The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum.",
            Complexity.N_LOG_N,
            Complexity.N_LOG_N,
            Complexity.N_LOG_N,
            Complexity.ONE,
            false),

    COUNTING_SORT("Counting Sort",
            "Counting sort is an algorithm for sorting a collection of objects according to keys that are small integers; that is, it is an integer sorting algorithm. " +
                    "It operates by counting the number of objects that have each distinct key value, and using arithmetic on those counts to determine the positions of each key value in the output sequence. " +
                    "Its running time is linear in the number of items and the difference between the maximum and minimum key values, so it is only suitable for direct use in situations where the variation in keys is not significantly greater than the number of items. " +
                    "However, it is often used as a subroutine in another sorting algorithm, radix sort, that can handle larger keys more efficiently.",
            Complexity.N_PLUS_K,
            Complexity.N_PLUS_K,
            Complexity.N_PLUS_K,
            Complexity.K,
            true),

    RADIX_SORT("Radix Sort",
            "Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping keys by the individual digits which share the same significant position and value. " +
                    "A positional notation is required, but because integers can represent strings of characters (e.g., names or dates) and specially formatted floating point numbers, radix sort is not limited to integers.",
            Complexity.N_K,
            Complexity.N_K,
            Complexity.N_K,
            Complexity.N_PLUS_K,
            true);




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
                + "Best case: "+ bestCase.prettyName  + "\n"
                + "Average case: " + averageCase.prettyName  + "\n"
                + "Worst case: " + worstCase.prettyName  + "\n"
                + "Space complexity: " + spaceComplexity.prettyName  + "\n"
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
