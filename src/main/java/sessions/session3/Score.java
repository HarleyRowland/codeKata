package sessions.session3;

import java.util.Arrays;

public enum Score {
    Love(0),
    Fifteen(1),
    Thirty(2),
    Forty(3);

    private int score;

    private Score(int score) {
        this.score = score;
    }

    public static String getScoreTextByValue(int score) {
            return Arrays.stream(Score.values())
                    .filter(v -> v.getScore() == (score))
                    .findFirst()
                    .orElse(Forty)
                    .toString();
    }

    public int getScore() {
        return score;
    }
}
