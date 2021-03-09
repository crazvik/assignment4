package se.ecutb.Field;

public interface ReplayInterface {
    void addLastMove(int[][] moves, char playerSymbol);
    void printLastMove(char[][] spaces) throws InterruptedException;
}
