package randori;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class TennisScoreboard {

    public static final int[] SCORE_CARDS = {0, 15, 30, 40};

    private int score1;
    private int score2;

    public void player1Scores() {
        score1++;
    }

    public void player2Scores() {
        score2++;
    }

    public void pointSequence(List<Integer> pointSequence) {
        score1 += pointSequence.stream()
                .filter(input -> input == 1)
                .count();
        score2 += pointSequence.stream()
                .filter(input -> input == 2)
                .count();
    }

    public String getScore() {
        // somebody won
        if (abs(score1 - score2) > 1 && max(score1, score2) >= SCORE_CARDS.length) {
            if (score1 > score2) {
                return "Player 1 won";
            }
            return "Player 2 won";
        }
        // advantage scenario
        else if (max(score1, score2) >= SCORE_CARDS.length) {
            // deuce
            if (score1 == score2) {
                return "40-40";
            }
            // one of the players has an advantage
            if (score1 > score2) {
                return "A-40";
            }
            return "40-A";
        }
        // game is in progress
        else {
            return SCORE_CARDS[score1] + "-" + SCORE_CARDS[score2];
        }
    }

}