package com.example.jeno.dartstracker.Entity;

import android.widget.TextView;

import com.example.jeno.dartstracker.Util.Counter;

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

    public boolean undo(){
        if (scoreBoard.getScoresSize() > 0){
            int currentScore = Integer.parseInt(score.getText().toString());
            int lastScore = scoreBoard.getLastScore();
            setScore(String.valueOf(currentScore + lastScore));
            scoreBoard.removeLast();
            scoreBoard.buildScoreBoard();
            return true;
        }
        return false;
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
