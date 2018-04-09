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

    public void handle(int inputScore){
        if (switcher.isPlayerSwitch()){
            handlePlayer(inputScore, player1);
        } else {
            handlePlayer(inputScore, player2);
        }
    }

    public void undo(){
        if (switcher.isPlayerSwitch()){
            undoPlayer(player2);
        } else {
            undoPlayer(player1);
        }
    }

    private void handlePlayer(int inputScore, Player player){
        int result = player.getScore() - inputScore;
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

    private void undoPlayer(Player player){
        player.undo();
        switcher.playerSwitcher();
    }

    public void resetScores(){
        player1.reset(startingScore);
        player2.reset(startingScore);
    }

}
