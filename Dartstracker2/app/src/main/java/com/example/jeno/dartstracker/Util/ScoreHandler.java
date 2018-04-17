package com.example.jeno.dartstracker.Util;

import com.example.jeno.dartstracker.Entity.Player;

public class ScoreHandler {

    private Player player1;
    private Player player2;
    private Switcher switcher;

    private int startingScore = 501;
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

    public void handleToScore(int input){
        if (switcher.isPlayerSwitch()){
            handlePlayerToScore(input, player1);
        } else {
            handlePlayerToScore(input, player2);
        }
    }

    private void handlePlayer(int inputScore, Player player){
        int result = player.getScore() - inputScore;
        if (result == 0){
            gameWinHandler(player);
        } else if (result > 1 && inputScore <= maxScore ){
            player.setScore(String.valueOf(result));
            player.getScoreBoard().addToScores(inputScore);
            switcher.playerSwitcher();
        }
        player.getScoreBoard().buildScoreBoard();
    }

    private void handlePlayerToScore(int input, Player player){
        if (input == 0){
            gameWinHandler(player);
        } else if ((input > player.getScore() - 181) && input <= player.getScore()){
            player.getScoreBoard().addToScores(player.getScore() - input);
            player.setScore(String.valueOf(input));
            switcher.playerSwitcher();
        }
        player.getScoreBoard().buildScoreBoard();
    }

    private void undoPlayer(Player player){
        boolean success = player.undo();
        if (success) switcher.playerSwitcher();
    }

    private void resetScores(){
        player1.reset(startingScore);
        player2.reset(startingScore);
    }

    private void gameWinHandler(Player player){
        resetScores();
        player.getLegCounter().incrementCounter();
        switcher.legSwitcher();
        switcher.setPlayerSwitch(switcher.isLegSwitch());
    }

    public void setStartingScore(int startingScore) {
        this.startingScore = startingScore;
    }
}
