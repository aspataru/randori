package randori;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestTennisScoreboardParam {

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return asList(new Object[][]{
                {singletonList(1), "15-0"},
                {singletonList(2), "0-15"},
                {asList(1, 1, 2), "30-15"},
                {asList(1, 1, 1, 1), "Player 1 won"},
                {asList(2, 2, 2, 2), "Player 2 won"},
                {asList(1, 1, 1, 2, 2, 2, 1), "A-40"},
                {asList(1, 1, 1, 2, 2, 2, 1, 2), "40-40"},
                {asList(1, 1, 1, 2, 2, 2, 2), "40-A"}
        });
    }

    private List<Integer> scoreSequence;

    private String expectedScore;

    public TestTennisScoreboardParam(List<Integer> scoreSequence, String expectedScore) {
        this.scoreSequence = scoreSequence;
        this.expectedScore = expectedScore;
    }

    @Test
    public void test() {
        TennisScoreboard scoreboard = new TennisScoreboard();

        scoreboard.pointSequence(scoreSequence);

        assertEquals(expectedScore, scoreboard.getScore());
    }
}

