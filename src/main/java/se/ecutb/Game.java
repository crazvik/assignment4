package se.ecutb;

import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private final PlayingField playingField;
    private final Scanner scanner;
    private int rounds;
    private int playedRounds;
    private int RNG;
    private boolean winner;

    public Game() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.playingField = new PlayingField();
        this.scanner = new Scanner(System.in);
        this.rounds = 0;
        this.playedRounds = 0;
    }

    public void setRounds() {
        try {
            System.out.print("Enter a number of rounds: ");
            rounds = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            setRounds();
        } finally {
            playingField.printField();
            round();
        }
    }

    public void round() {
        RNG = (int)(Math.random()*2+1);
        playedRounds++;
        System.out.println("Round " + playedRounds);
        System.out.println("Player " + RNG + " starts");
        playerChoice();
    }

    public void playerChoice() {
        while (!player1.getWinner() || !player2.getWinner()) {
            try {
                if (RNG == 1) {
                    System.out.print("Choose a position: ");
                    RNG = playingField.addPlay(Integer.parseInt(scanner.nextLine()), 'X', RNG);
                } else {
                    System.out.print("Choose a position: ");
                    RNG = playingField.addPlay(Integer.parseInt(scanner.nextLine()), 'O', RNG);
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
                playerChoice();
            }
        }
    }

}
