package algorithms;

// 🟢 🟡 🟠 🔴
public enum Complexity {
    ONE("O(1)", 1, "\uD83D\uDFE2"),
    LOG_N("O(log n)", 2,"\uD83D\uDFE2"),
    N("O(n)", 3, "\uD83D\uDFE1"),
    N_LOG_N("O(n log n)", 4, "\uD83D\uDFE0"),
    N_SQUARED("O(n^2)", 5, "\uD83D\uDD34"),
    N_CUBED("O(n^3)", 6, "\uD83D\uDD34"),
    N_PLUS_ONE_FACT("O(n!)", 7, "\uD83D\uDD34"),
    INFINITY("O(∞)", 7, "\uD83D\uDD34");
    public final String prettyName;
    public final int rating;
    public final String emoji;


    Complexity(String prettyName, int rating, String emoji) { //
        this.prettyName = prettyName;
        this.rating = rating;
        this.emoji = emoji;
    }
}