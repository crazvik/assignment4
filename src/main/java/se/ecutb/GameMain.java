package se.ecutb;

import se.ecutb.Game.Game;

public class GameMain {
    public static Game game = new Game();
    public static void main( String[] args ) throws InterruptedException {
        game.engine();
    }
}
