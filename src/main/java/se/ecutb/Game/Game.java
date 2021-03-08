package se.ecutb.Game;

import se.ecutb.Player;
import se.ecutb.Field.PlayingField;

import java.util.Scanner;

public class Game implements GameInterface {
    private final Player player1;
    private final Player player2;
    private final PlayingField playingField;
    private final Scanner scanner;
    private int rounds;
    private int playedRounds;
    private int turns;
    private int RNG;
    private boolean winner;

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
    public void engine() {
        playingField.printField();
        System.out.print("\nEnter a number of rounds: ");
        while (!setRounds()) {
            System.out.print("Enter a number of rounds: ");
        }
        printRounds();
        while (!player1.getWinner() || !player2.getWinner()) {
            playerChoice();
            playingField.printField();
            if (Math.round((double) turns/2)>=0) {
                if(checkWinner(player1, player2)) {
                    if (player1.getWinner()) {
                        System.out.println("Player 1 wins round " + playedRounds);
                    } else {
                        System.out.println("Player 2 wins round " + playedRounds);
                    }
                    break;
                }
            }
        }
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
        if (playingField.straightRows(player.getSymbol())) {
            player.setScore(player.getScore()+1);
            return true;
        } else {
            player.setScore(player.getScore()+1);
            return playingField.diagonalRow(player.getSymbol());
        }
    }

    /*
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
                    RNG = playingField.addPlay(Integer.parseInt(scanner.nextLine()), player1.getSymbol(), RNG);
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
     */

}
