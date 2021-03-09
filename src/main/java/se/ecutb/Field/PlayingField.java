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
            for(int row=spaces.length-1; row>0; row--) {
                if (spaces[position-1][row-1] == ' ') {
                    spaces[position-1][row-1] = playerSymbol;
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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


     || spaces[row+1][col]==symbol
     spaces[col+1][row]==symbol ||




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
