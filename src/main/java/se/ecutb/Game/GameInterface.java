package se.ecutb.Game;

import se.ecutb.Player;

public interface GameInterface {
    void engine() throws InterruptedException;
    boolean setRounds();
    void printRounds();
    void playerChoice();
    boolean checkWinner(Player player1, Player player2);
    boolean checkRow(Player player);
}
