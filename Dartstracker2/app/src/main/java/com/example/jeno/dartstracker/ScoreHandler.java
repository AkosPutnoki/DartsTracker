package com.example.jeno.dartstracker;

public class ScoreHandler {

    private Player player1;
    private Player player2;
    private Switcher switcher;

    private final int startingScore = 501;
    private final int maxScore = 180;

    public ScoreHandler(Player player1, Player player2, Switcher switcher) {
        this.player1 = player1;
        this.player2 = player2;
        this.switcher = switcher;
    }

    public void handle(int originalScore1, int originalScore2, int inputScore){
        if (switcher.isPlayerSwitch()){
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
            switcher.legSwitcher();
            switcher.setPlayerSwitch(switcher.isLegSwitch());
        } else if (result > 1 && inputScore <= maxScore ){
            player.setScore(String.valueOf(result));
            player.getScoreBoard().addToScores(inputScore);
            switcher.playerSwitcher();
        }
        player.getScoreBoard().buildScoreBoard();
    }

    public void resetScores(){
        player1.reset(startingScore);
        player2.reset(startingScore);
    }

}
