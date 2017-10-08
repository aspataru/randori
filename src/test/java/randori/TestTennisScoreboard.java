package randori;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTennisScoreboard {

    private TennisScoreboard scoreboard;

    @Before
    public void init() {
        scoreboard = new TennisScoreboard();
    }

    @Test
    public void shouldReturnEmptyScore() {
        assertEquals("0-0", scoreboard.getScore());
    }

    @Test
    public void shouldScoreFirstForPlayer1() {
        scoreboard.player1Scores();

        assertEquals("15-0", scoreboard.getScore());
    }

    @Test
    public void shouldScoreFirstForPlayer2() {
        scoreboard.player2Scores();

        assertEquals("0-15", scoreboard.getScore());
    }

    @Test
    public void shouldDetectPlayer1Winning() {
        scoreboard.player1Scores();
        scoreboard.player1Scores();
        scoreboard.player1Scores();
        scoreboard.player1Scores();

        assertEquals("Player 1 won", scoreboard.getScore());
    }

    @Test
    public void shouldDetectPlayer2Winning() {
        scoreboard.player2Scores();
        scoreboard.player2Scores();
        scoreboard.player2Scores();
        scoreboard.player2Scores();

        assertEquals("Player 2 won", scoreboard.getScore());
    }

    @Test
    public void shouldGetToAdvantageP1() {
        scoreboard.player1Scores();
        scoreboard.player1Scores();
        scoreboard.player1Scores();

        scoreboard.player2Scores();
        scoreboard.player2Scores();
        scoreboard.player2Scores();

        scoreboard.player1Scores();

        assertEquals("A-40", scoreboard.getScore());
    }

    @Test
    public void shouldGetBackToDeuceAfterAdvantageIsRemoved() {
        scoreboard.player1Scores();
        scoreboard.player1Scores();
        scoreboard.player1Scores();

        scoreboard.player2Scores();
        scoreboard.player2Scores();
        scoreboard.player2Scores();

        scoreboard.player1Scores();

        scoreboard.player2Scores();

        assertEquals("40-40", scoreboard.getScore());
    }
}
