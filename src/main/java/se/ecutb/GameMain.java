package se.ecutb;

import se.ecutb.game.Game;

public class GameMain {
    public static final Game game = new Game();
    public static void main( String[] args ) throws InterruptedException {
        game.engine();
    }
}
