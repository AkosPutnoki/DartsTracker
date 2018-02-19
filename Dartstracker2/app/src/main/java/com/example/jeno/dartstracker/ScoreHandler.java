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
    private TextView legCounterPlayerOne;
    private TextView legCounterPlayerTwo;

    // other fields
    private final int startingScore = 501;
    private final int maxScore = 180;
    private boolean playerRoundSwitch;
    private boolean playerLegSwitch;

    public ScoreHandler(ScoreBoard scoreBoardPlayerOne, ScoreBoard scoreBoardPlayerTwo, TextView scorePlayerOne,
                        TextView scorePlayerTwo, EditText input, TextView legCounterPlayerOne,
                        TextView legCounterPlayerTwo) {
        this.scoreBoardPlayerOne = scoreBoardPlayerOne;
        this.scoreBoardPlayerTwo = scoreBoardPlayerTwo;
        this.scorePlayerOne = scorePlayerOne;
        this.scorePlayerTwo = scorePlayerTwo;
        this.input = input;
        this.legCounterPlayerOne = legCounterPlayerOne;
        this.legCounterPlayerTwo = legCounterPlayerTwo;
        this.playerRoundSwitch = true;
        this.playerLegSwitch = true;
    }

    public void handle(int originalScore1, int originalScore2, int inputScore){
        if (playerRoundSwitch){
            handlePlayer(originalScore1, inputScore, scoreBoardPlayerOne, scorePlayerOne, legCounterPlayerOne);
        } else {
            handlePlayer(originalScore2, inputScore, scoreBoardPlayerTwo, scorePlayerTwo, legCounterPlayerTwo);
        }

    }

    public void handlePlayer(int originalScore, int inputScore, ScoreBoard scoreBoard, TextView currentScore, TextView legCounter){
        int result = originalScore - inputScore;
        if (result == 0){
            resetScores();
            legCounterUpdate(legCounter);
            playerLegSwitcher();
            setPlayerRoundSwitch(playerLegSwitch);
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

    public void legCounterUpdate(TextView legCounter){
        int currentCount = Integer.parseInt(legCounter.getText().toString());
        legCounter.setText(String.valueOf(currentCount + 1));
    }

    public void playerRoundSwitcher(){
        playerRoundSwitch = !playerRoundSwitch;
    }

    public void playerLegSwitcher(){
        playerLegSwitch = !playerLegSwitch;
    }

    public void setPlayerRoundSwitch(boolean playerRoundSwitch) {
        this.playerRoundSwitch = playerRoundSwitch;
    }

}
