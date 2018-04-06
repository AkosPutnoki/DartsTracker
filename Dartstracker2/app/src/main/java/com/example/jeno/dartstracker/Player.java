package com.example.jeno.dartstracker;

import android.widget.TextView;

public class Player {

    private String name;
    private static boolean playerSwitch = true;
    private static boolean legSwitch = true;
    private TextView score;
    private ScoreBoard scoreBoard;
    private Counter legCounter;
    //TODO
    private Counter setCounter;

    // CONSTRUCTOR

    public Player(String name, TextView score, ScoreBoard scoreBoard, TextView legCounter) {
        this.name = name;
        this.score = score;
        this.scoreBoard = scoreBoard;
        this.legCounter = new Counter(legCounter);
    }


    // STATIC METHODS

    public static boolean isPlayerSwitch(){
        return playerSwitch;
    }

    public static boolean isLegSwitch(){
        return legSwitch;
    }

    public static void playerSwitcher(){
        playerSwitch = !playerSwitch;
    }

    public static void setPlayerSwitch(boolean toSet){
        playerSwitch = toSet;
    }

    public static void legSwitcher(){
        legSwitch = !legSwitch;
    }

    // UTILITY METHODS

    public void reset(int startingScore){
        score.setText(String.valueOf(startingScore));
        scoreBoard.clearScores();
        scoreBoard.clearScoreBoard();
    }

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counter getLegCounter() {
        return legCounter;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScore(String toSet) {
        this.score.setText(toSet);
    }
}
