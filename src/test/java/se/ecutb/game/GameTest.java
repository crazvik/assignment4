package se.ecutb.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.ecutb.Player;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private Player player;

    @BeforeEach
    void setUp() {
        game = new Game();
        player = new Player('§');
    }

    @Test
    void setRounds() {
        assertTrue(game.setRounds(1));
        assertEquals(game.getRounds(), 1);
        game.setRounds((int) 3.5);
        assertNotEquals(game.getRounds(), 3.5);
    }

    @Test
    void printRounds() {
        assertEquals(game.getPlayedRounds(), 0);
        game.printRounds();
        assertNotEquals(game.getPlayedRounds(), 2);
    }

    @Test
    void playerChoice() {
        game.setRNG(2);
        game.playerChoice(2);
        assertEquals(game.getRNG(), 1);
        assertEquals(game.getTurns(), 1);
        game.playerChoice(8);
        assertNotEquals(game.getRNG(), 2);
    }

    @Test
    void checkWinner() {
        game.playerChoice(1);
        game.playerChoice(1);
        game.playerChoice(1);
        game.playerChoice(1);
        assertFalse(game.checkWinner(game.getPlayer1(), player));
        game.playerChoice(2);
        game.playerChoice(3);
        game.playerChoice(2);
        game.playerChoice(3);
        game.playerChoice(2);
        game.playerChoice(3);
        game.playerChoice(2);
        assertTrue(game.checkWinner(game.getPlayer1(), game.getPlayer2()));
    }

    @Test
    void checkRow() {
        game.playerChoice(1);
        game.playerChoice(2);
        game.playerChoice(1);
        assertFalse(game.checkRow(game.getPlayer2()));
        game.playerChoice(2);
        game.playerChoice(1);
        game.playerChoice(2);
        game.playerChoice(1);
        assertTrue(game.checkRow(game.getPlayer2()));
    }
}