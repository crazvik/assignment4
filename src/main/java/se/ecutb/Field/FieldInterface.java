package se.ecutb.Field;

public interface FieldInterface {
    void printField();
    void clearField();
    int addPlay(int position, char playerSymbol, int rng);
    boolean horizontalRows(char symbol);
    boolean verticalRows(char symbol);
    boolean diagonalRowRight(char symbol);
    boolean diagonalRowLeft(char symbol);
    void runReplay() throws InterruptedException;
}

