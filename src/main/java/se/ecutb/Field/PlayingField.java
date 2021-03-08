package se.ecutb.Field;

import java.util.Arrays;

public class PlayingField implements FieldInterface {
    private final char[][] spaces;

    public PlayingField() {
        this.spaces = new char[7][6];
        for (char[] row:
             spaces) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public void printField() {
        for (int col = 0; col < spaces[0].length; col++) {
            for (int i = 0; i < spaces.length; i++) {
                System.out.print("+ - ");
            }
            System.out.println("+");
            for (int i = 0; i <= spaces[0].length; i++) {
                System.out.print("| " + spaces[i][col] + " ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < spaces.length; i++) {
            System.out.print("+ - ");
        }
        System.out.println("+");
    }

    @Override
    public void clearField() {
        for (char[] row:
                spaces) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public int addPlay(int position, char playerSymbol, int rng) {
        try {
            for(int col=spaces[position-1].length-1; col>=0; col--) {
                if (spaces[position-1][col] == ' ') {
                    spaces[position-1][col] = playerSymbol;
                    if (rng==1) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }
            return rng;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds! Try again");
            return rng;
        }
    }

    @Override
    public boolean straightRows(char symbol) {
        int numberInRow = 0;
        for(int row=0; row<spaces.length-1; row++) {
            for (int col=0; col<spaces[row].length; col++) {
                if (spaces[col][row]==symbol || spaces[col+1][row]==symbol ||
                        spaces[row][col]==symbol || spaces[row+1][col]==symbol) {
                    numberInRow++;
                    if (numberInRow==4) {
                        return true;
                    }
                } else {
                    numberInRow=0;
                }
            }
        }
        return false;
    }

    @Override
    public boolean diagonalRow(char symbol) {
        return false;
    }

    /*
    public void printField() {
        for (int col = 0; col < spaces[0].length; col++) {
            for (int i = 0; i < spaces.length; i++) {
                System.out.print("+ - ");
            }
            System.out.println("+");
            for (int i = 0; i <= spaces[0].length; i++) {
                System.out.print("| " + spaces[i][col] + " ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < spaces.length; i++) {
            System.out.print("+ - ");
        }
        System.out.println("+");
    }

    public int addPlay(int position, char playerSymbol, int rng) {
        for(int col=spaces[position].length-1; col>=0; col--) {
            if (spaces[position][col] == ' ') {
                spaces[position][col] = playerSymbol;
                if (rng==1) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        printField();
        return rng;
    }

    public Player checkWinner(Player player) {

        return player;
    }

    public boolean horizontalRow() {
        for(int row=spaces.length-1; row>=0; row--) {
            int numberInRow = 0;
            for (int col=0; col<spaces[row].length; col++) {
                if (spaces[row][col]!=' ') {
                    numberInRow++;
                }
                if (numberInRow==4) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalRow() {
        for (char[] space : spaces) {
            int numberInRow = 0;
            for (int col = space.length - 1; col > 0; col--) {
                if (space[col] != ' ') {
                    numberInRow++;
                }
                if (numberInRow == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagonalRow() {
        return false;
    }*/
}
