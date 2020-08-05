package codeKata;


public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return handleDrawingScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return handleWinOrAdvantage();
        } else {
            return getScoreValue(player1Score) + "-" + getScoreValue(player2Score);
        }
    }

    private String handleDrawingScore(){
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String handleWinOrAdvantage(){
        int scoreCalculation = player1Score - player2Score;
        if (scoreCalculation == 1) {
            return "Advantage player1";
        } else if (scoreCalculation == -1) {
            return "Advantage player2";
        } else if (scoreCalculation >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getScoreValue(int score){
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}