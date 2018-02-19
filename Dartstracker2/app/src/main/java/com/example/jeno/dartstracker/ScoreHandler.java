package com.example.jeno.dartstracker;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jeno on 2018. 02. 19..
 */

public class ScoreHandler {

    // View fields
    private ScoreBoard scoreBoardPlayerOne;
    private ScoreBoard scoreBoardPlayerTwo;
    private TextView scorePlayerOne;
    private TextView scorePlayerTwo;
    private EditText input;

    // other fields
    private final int startingScore = 501;
    private final int maxScore = 180;
    private boolean playerRoundSwitch;
    private boolean playerLegSwitch;

    public ScoreHandler(ScoreBoard scoreBoardPlayerOne, ScoreBoard scoreBoardPlayerTwo, TextView scorePlayerOne, TextView scorePlayerTwo, EditText input) {
        this.scoreBoardPlayerOne = scoreBoardPlayerOne;
        this.scoreBoardPlayerTwo = scoreBoardPlayerTwo;
        this.scorePlayerOne = scorePlayerOne;
        this.scorePlayerTwo = scorePlayerTwo;
        this.input = input;
        this.playerRoundSwitch = true;
        this.playerLegSwitch = true;
    }

    public void handle(int originalScore1, int originalScore2, int inputScore){
        if (playerRoundSwitch){
            handlePlayer(originalScore1, inputScore, scoreBoardPlayerOne, scorePlayerOne);
        } else {
            handlePlayer(originalScore2, inputScore, scoreBoardPlayerTwo, scorePlayerTwo);
        }

    }

    public void handlePlayer(int originalScore, int inputScore, ScoreBoard scoreBoard, TextView currentScore){
        int result = originalScore - inputScore;
        if (result == 0){
            resetScores();
        } else if (result > 1 && inputScore <= maxScore ){
            currentScore.setText(String.valueOf(result));
            scoreBoard.addToScores(inputScore);
            playerRoundSwitcher();
        }
        scoreBoard.buildScoreBoard();
    }

    public void resetScores(){
        scorePlayerOne.setText(String.valueOf(startingScore));
        scorePlayerTwo.setText(String.valueOf(startingScore));
        scoreBoardPlayerOne.clearScores();
        scoreBoardPlayerTwo.clearScores();
        scoreBoardPlayerOne.clearScoreBoard();
        scoreBoardPlayerTwo.clearScoreBoard();
    }

    public void playerRoundSwitcher(){
        playerRoundSwitch = !playerRoundSwitch;
    }

    public void playerLegSwitcher(){
        playerLegSwitch = !playerLegSwitch;
    }
}
