package algorithms;

public enum Complexity {
    ONE("O(1)"),
    LOG_N("O(log n)"),
    N("O(n)"),
    N_LOG_N("O(n log n)"),
    K("O(k)"),
    N_PLUS_K("O(n + k)"),
    N_K("O(nk)"),
    N_SQUARED("O(n^2)"),
    N_CUBED("O(n^3)"),
    N_PLUS_ONE_FACT("O(n!)"),
    INFINITY("O(∞)");
    public final String prettyName;


    Complexity(String prettyName) { //
        this.prettyName = prettyName;
    }
}