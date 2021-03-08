package se.ecutb;

import java.util.Objects;

public class Player {
    private int score;
    private boolean winner;
    private char symbol;

    public Player(char symbol) {
        this.score = 0;
        this.winner = false;
        this.symbol = symbol;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && winner == player.winner && symbol == player.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, winner, symbol);
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", winner=" + winner +
                ", symbol=" + symbol +
                '}';
    }
}
