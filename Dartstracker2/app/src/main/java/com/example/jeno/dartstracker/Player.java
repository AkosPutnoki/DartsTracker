package com.example.jeno.dartstracker;

import android.widget.TextView;

public class Player {

    private String name;
    private TextView score;
    private ScoreBoard scoreBoard;
    private Counter legCounter;

    // CONSTRUCTOR

    public Player(String name, TextView score, ScoreBoard scoreBoard, TextView legCounter) {
        this.name = name;
        this.score = score;
        this.scoreBoard = scoreBoard;
        this.legCounter = new Counter(legCounter);
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

    public int getScore() {
        return Integer.parseInt(score.getText().toString());
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
