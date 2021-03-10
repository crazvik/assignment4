package se.ecutb.field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PlayingFieldTest {
    private PlayingField playingField;

    @BeforeEach
    void setUp() {
        playingField = new PlayingField();
    }

    @Test
    void printField() {
        for (int i=0; i<playingField.getSpaces().length; i++) {
            for (int j=0; j<playingField.getSpaces()[i].length; j++) {
                assertEquals(playingField.getSpaces()[i][j], ' ');
            }
        }
    }

    @Test
    void clearField() {
        for (int i=0; i<playingField.getSpaces().length; i++) {
            Arrays.fill(playingField.getSpaces()[i], 'X');
        }
        assertEquals(playingField.getSpaces()[0][0], 'X');
        playingField.clearField();
        for (int i=0; i<playingField.getSpaces().length; i++) {
            for (int j=0; j<playingField.getSpaces()[i].length; j++) {
                assertEquals(playingField.getSpaces()[i][j], ' ');
            }
        }
    }

    @Test
    void addPlay() {
        playingField.addPlay(1, 'X', 1);
        assertEquals(playingField.addPlay(1, 'O', 2), 1);
        assertEquals(playingField.getSpaces()[0][5], 'X');
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(1, 'O', 2);
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(1, 'O', 2);
        assertNotEquals(playingField.addPlay(1, 'X', 1), 2);
        assertNotEquals(playingField.getSpaces()[0][0], 'X');
    }

    @Test
    void horizontalRows() {
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(2, 'X', 1);
        playingField.addPlay(3, 'X', 1);
        playingField.addPlay(4, 'X', 1);
        assertTrue(playingField.horizontalRows('X'));
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(2, 'O', 2);
        playingField.addPlay(3, 'X', 1);
        playingField.addPlay(4, 'X', 1);
        assertFalse(playingField.horizontalRows('O'));
    }

    @Test
    void verticalRows() {
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(1, 'X', 1);
        assertTrue(playingField.verticalRows('X'));
        playingField.addPlay(2, 'X', 1);
        playingField.addPlay(2, 'O', 2);
        playingField.addPlay(2, 'X', 1);
        playingField.addPlay(2, 'X', 1);
        assertFalse(playingField.horizontalRows('O'));
    }

    @Test
    void diagonalRowRight() {
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(2, 'O', 2);
        playingField.addPlay(2, 'X', 1);
        playingField.addPlay(3, 'O', 2);
        playingField.addPlay(3, 'O', 2);
        playingField.addPlay(3, 'X', 1);
        playingField.addPlay(4, 'O', 2);
        playingField.addPlay(4, 'O', 2);
        playingField.addPlay(4, 'O', 2);
        playingField.addPlay(4, 'X', 1);
        assertTrue(playingField.diagonalRowRight('X'));
        playingField.addPlay(1, 'X', 1);
        playingField.addPlay(2, 'O', 2);
        playingField.addPlay(3, 'X', 1);
        playingField.addPlay(4, 'X', 1);
        assertFalse(playingField.diagonalRowRight('O'));
    }

    @Test
    void diagonalRowLeft() {
        playingField.addPlay(7, 'X', 1);
        playingField.addPlay(6, 'O', 2);
        playingField.addPlay(6, 'X', 1);
        playingField.addPlay(5, 'O', 2);
        playingField.addPlay(5, 'O', 2);
        playingField.addPlay(5, 'X', 1);
        playingField.addPlay(4, 'O', 2);
        playingField.addPlay(4, 'O', 2);
        playingField.addPlay(4, 'O', 2);
        playingField.addPlay(4, 'X', 1);
        assertTrue(playingField.diagonalRowLeft('X'));
        playingField.addPlay(7, 'X', 1);
        playingField.addPlay(6, 'O', 2);
        playingField.addPlay(5, 'X', 1);
        playingField.addPlay(4, 'X', 1);
        assertFalse(playingField.diagonalRowLeft('O'));
    }

    @Test
    void runReplay() throws InterruptedException {
        horizontalRows();
        assertNotEquals(playingField.getSpaces()[0][0], 'X');
        playingField.runReplay();
        assertEquals(playingField.getSpaces()[0][0], ' ');
    }
}