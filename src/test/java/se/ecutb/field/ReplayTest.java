package se.ecutb.field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReplayTest {
    private PlayingField playingField;
    private Replay replay;
    private int[][] testArray;
    private char testSymbol;

    @BeforeEach
    void setUp() {
        playingField = new PlayingField();
        replay = new Replay();
        testSymbol = 'O';
        testArray = new int[][] {{1,5}, {1,0}};
    }

    @Test
    void addLastMove() {
        int[][] secondArray = new int[][] {{2,3}};
        replay.addLastMove(testArray, testSymbol);
        assertEquals(replay.getPastSymbols().get(0), testSymbol);
        assertArrayEquals(replay.getPastMoves().get(0)[0], testArray[0]);
        assertNotEquals(replay.getPastMoves().size(), 2);
        replay.addLastMove(secondArray, testSymbol);
        assertEquals(replay.getPastMoves().size(), 2);
    }

    @Test
    void printLastMove() throws InterruptedException {
        replay.addLastMove(testArray, testSymbol);
        replay.printLastMove(playingField.getSpaces());
        assertEquals(testSymbol, playingField.getSpaces()[1][5]);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            assertNotEquals(testSymbol, playingField.getSpaces()[1][6]);
        });
    }
}