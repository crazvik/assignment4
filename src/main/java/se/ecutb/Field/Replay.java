package se.ecutb.Field;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Replay implements ReplayInterface {
    private final ArrayList<int[][]> pastMoves;
    private final ArrayList<Character> pastSymbols;

    public Replay() {
        this.pastSymbols = new ArrayList<>();
        this.pastMoves = new ArrayList<>();
    }

    @Override
    public void addLastMove(int[][] moves, char playerSymbol) {
        pastMoves.add(moves);
        pastSymbols.add(playerSymbol);
    }

    @Override
    public void printLastMove(char[][] spaces) throws InterruptedException {
        for(int i=0; i<pastMoves.size(); i++) {
            System.out.println("\nTurn " + (i+1));
            spaces[pastMoves.get(i)[0][0]][pastMoves.get(i)[0][1]] = pastSymbols.get(i);
            PlayingField.printField(spaces);
            System.out.println("+");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}