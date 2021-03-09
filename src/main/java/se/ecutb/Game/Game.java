package se.ecutb.Game;

import se.ecutb.Player;
import se.ecutb.Field.PlayingField;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game implements GameInterface {
    private final Player player1;
    private final Player player2;
    private final PlayingField playingField;
    private final Scanner scanner;
    private int rounds;
    private int playedRounds;
    private int turns;
    private int RNG;

    public Game() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.playingField = new PlayingField();
        this.scanner = new Scanner(System.in);
        this.rounds = 0;
        this.playedRounds = 0;
        this.turns = 0;
    }

    @Override
    public void engine() throws InterruptedException {
        playingField.printField();
        System.out.print("\nEnter a number of rounds: ");
        while (!setRounds()) {
            System.out.print("Enter a number of rounds: ");
        }
        while (playedRounds<rounds) {
            printRounds();
            while (!player1.getWinner() || !player2.getWinner()) {
                playerChoice();
                playingField.printField();
                if (Math.round((double) turns / 2) >= 0) { // Minimum amount of turns before potential victory
                    if (checkWinner(player1, player2)) {
                        if (player1.getWinner()) {
                            player1.setScore(player1.getScore() + 1);
                        } else {
                            player2.setScore(player2.getScore() + 1);
                        }
                        System.out.println("\nPlayer 1 score: " + player1.getScore() +
                                            "\nPlayer 2 score: " + player2.getScore());
                        break;
                    }
                }
                if (turns==44) {
                    rounds--;
                    System.out.println("Tie!");
                    break;
                }
            }
            if (Math.round((double) rounds/2)<=player1.getScore()) {
                System.out.println("\nPlayer 1 wins!");
                break;
            } else if (Math.round((double) rounds/2)<=player2.getScore()) {
                System.out.println("\nPlayer 2 wins!");
                break;
            }
            playingField.clearField();
            player1.setWinner(false);
            player2.setWinner(false);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.print("Do you want to see a replay of the last round? Type Y for yes: ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            playingField.runReplay();
        }
        System.out.println("\nThanks for playing!");
    }

    @Override
    public boolean setRounds() {
        try {
            this.rounds = Integer.parseInt(scanner.nextLine());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return false;
        }
    }

    @Override
    public void printRounds() {
        RNG = (int)(Math.random()*2+1);
        playedRounds++;
        System.out.println("\nRound " + playedRounds);
        System.out.println("Player " + RNG + " starts");
    }

    @Override
    public void playerChoice() {
        try {
            System.out.print("\nPlayer " + RNG + ", choose a position between 1-7: ");
            if (RNG == 1) {
                RNG = playingField.addPlay(Integer.parseInt(scanner.nextLine()), player1.getSymbol(), RNG);
            } else {
                RNG = playingField.addPlay(Integer.parseInt(scanner.nextLine()), player2.getSymbol(), RNG);
            }
            turns++;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    @Override
    public boolean checkWinner(Player player1, Player player2) {
        if (RNG==2) {
            player1.setWinner(checkRow(player1));
            return player1.getWinner();
        } else {
            player2.setWinner(checkRow(player2));
            return player2.getWinner();
        }
    }

    @Override
    public boolean checkRow(Player player) {
        if (playingField.horizontalRows(player.getSymbol())) {
            return true;
        } else if (playingField.verticalRows(player.getSymbol())) {
            return true;
        } else if (playingField.diagonalRowRight(player.getSymbol())){
            return true;
        } else {
            return playingField.diagonalRowLeft(player.getSymbol());
        }
    }
}