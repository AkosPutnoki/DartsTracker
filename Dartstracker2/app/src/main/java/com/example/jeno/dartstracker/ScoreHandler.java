package com.example.jeno.dartstracker;

public class ScoreHandler {

    private Player player1;
    private Player player2;

    private final int startingScore = 501;
    private final int maxScore = 180;

    public ScoreHandler(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void handle(int originalScore1, int originalScore2, int inputScore){
        if (Player.isPlayerSwitch()){
            handlePlayer(originalScore1, inputScore, player1);
        } else {
            handlePlayer(originalScore2, inputScore, player2);
        }

    }

    public void handlePlayer(int originalScore, int inputScore, Player player){
        int result = originalScore - inputScore;
        if (result == 0){
            resetScores();
            player.getLegCounter().incrementCounter();
            Player.legSwitcher();
            Player.setPlayerSwitch(Player.isLegSwitch());
        } else if (result > 1 && inputScore <= maxScore ){
            player.setScore(String.valueOf(result));
            player.getScoreBoard().addToScores(inputScore);
            Player.playerSwitcher();
        }
        player.getScoreBoard().buildScoreBoard();
    }

    public void resetScores(){
        player1.reset(startingScore);
        player2.reset(startingScore);
    }

}
