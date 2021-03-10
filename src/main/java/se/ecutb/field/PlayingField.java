package se.ecutb.field;

import java.util.Arrays;

public class PlayingField {
    private final char[][] spaces;
    private final Replay replay;

    public char[][] getSpaces() {
        return spaces;
    }

    public PlayingField() {
        this.spaces = new char[7][6];
        for (char[] row:
             spaces) {
            Arrays.fill(row, ' ');
        }
        this.replay = new Replay();
    }

    public void printField() {
        printField(spaces);
    }

    public static void printField(char[][] spaces) {
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

    public void clearField() {
        for (char[] row:
                spaces) {
            Arrays.fill(row, ' ');
        }
    }

    public int addPlay(int position, char playerSymbol, int rng) {
        int[][][] tempArr = new int[1][1][2];
        try {
            for(int row=spaces.length-1; row>0; row--) {
                if (spaces[position-1][row-1] == ' ') {
                    spaces[position-1][row-1] = playerSymbol;
                    tempArr[0][0][0] = position-1;
                    tempArr[0][0][1] = row-1;
                    replay.addLastMove(tempArr[0], playerSymbol);
                    if (rng==1) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }
            System.out.println("Position already taken! Please chose another");
            return rng;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds! Try again");
            return rng;
        }
    }

    public boolean horizontalRows(char symbol) {
        for(int row=spaces.length-2; row>0; row--) {
            for (int col=0; col<=3; col++) {
                if (spaces[col][row]==symbol
                        && spaces[col+1][row]==symbol
                        && spaces[col+2][row]==symbol
                        && spaces[col+3][row]==symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalRows(char symbol) {
        for(int col=0; col<spaces.length-1; col++) {
            for(int row=spaces[col].length-1; row>=3; row--) {
                if (spaces[col][row]==symbol
                        && spaces[col][row-1]==symbol
                        && spaces[col][row-2]==symbol
                        && spaces[col][row-3]==symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagonalRowRight(char symbol) {
        for(int col=0; col<=3; col++) {
            for (int row=spaces[col].length-1; row>=0; row--) {
                if (spaces[col][row]==symbol
                        && spaces[col+1][row-1]==symbol
                        && spaces[col+2][row-2]==symbol
                        && spaces[col+3][row-3]==symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagonalRowLeft(char symbol) {
        for(int col=spaces.length-1; col>=3; col--) {
            for (int row=spaces[col].length-1; row>=0; row--) {
                if (spaces[col][row]==symbol
                        && spaces[col-1][row-1]==symbol
                        && spaces[col-2][row-2]==symbol
                        && spaces[col-3][row-3]==symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    public void runReplay() throws InterruptedException {
        clearField();
        replay.printLastMove(spaces);
    }
}
