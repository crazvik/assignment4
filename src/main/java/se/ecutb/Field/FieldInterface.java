package se.ecutb.Field;

public interface FieldInterface {
    void printField();
    void clearField();
    int addPlay(int position, char playerSymbol, int rng);
    boolean straightRows(char symbol);
    boolean diagonalRow(char symbol);
}

