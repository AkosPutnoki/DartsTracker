package com.example.jeno.dartstracker;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jeno on 2018. 02. 19.
 */

public class ScoreHandler {

    /**
     * These view fields are representing the UI elements the class is "handling"
     */
    private ScoreBoard scoreBoardPlayerOne;
    private ScoreBoard scoreBoardPlayerTwo;
    private TextView scorePlayerOne;
    private TextView scorePlayerTwo;
    private TextView legCounterPlayerOne;
    private TextView legCounterPlayerTwo;

    /**
     * These fields are for further functionality tied to the handling logic
     * startingScore: Starting score of a player in a leg. (Planning to make it dynamic)
     * maxScore: Maximum score possible in a round for a player.
     * playerRoundSwitch: Boolean field that is responsible for switching between players between rounds.
     * playerLegSwitch: Boolean field that is responsible for switching between the starting players between legs.
     */
    private final int startingScore = 501;
    private final int maxScore = 180;
    private boolean playerRoundSwitch;
    private boolean playerLegSwitch;


    /**
     * Constructor for the ScoreHandler class.
     */
    public ScoreHandler(ScoreBoard scoreBoardPlayerOne, ScoreBoard scoreBoardPlayerTwo, TextView scorePlayerOne,
                        TextView scorePlayerTwo, TextView legCounterPlayerOne,
                        TextView legCounterPlayerTwo) {
        this.scoreBoardPlayerOne = scoreBoardPlayerOne;
        this.scoreBoardPlayerTwo = scoreBoardPlayerTwo;
        this.scorePlayerOne = scorePlayerOne;
        this.scorePlayerTwo = scorePlayerTwo;
        this.legCounterPlayerOne = legCounterPlayerOne;
        this.legCounterPlayerTwo = legCounterPlayerTwo;
        this.playerRoundSwitch = true;
        this.playerLegSwitch = true;
    }

    /**
     * handle() method that is responsible for following through on the game logic
     * Called at every clickEvent of the OK button
     * @param originalScore1: current score of player 1
     * @param originalScore2: current score of player 2
     * @param inputScore: input number from user
     */
    public void handle(int originalScore1, int originalScore2, int inputScore){
        if (playerRoundSwitch){
            handlePlayer(originalScore1, inputScore, scoreBoardPlayerOne, scorePlayerOne, legCounterPlayerOne);
        } else {
            handlePlayer(originalScore2, inputScore, scoreBoardPlayerTwo, scorePlayerTwo, legCounterPlayerTwo);
        }

    }

    /**
     * handlePlayer() method is responsible for subtracting the input number from the current players current score.
     * Also checks for a win, in which case it resets the scoreBoards, increments the winning players leg count
     * and handles the legSwitch logic between the players.
     * @param originalScore: current players score
     * @param inputScore: input from user
     * @param scoreBoard: ScoreBoard object that should be updated
     * @param currentScore: TextView object of current score that should be updated
     * @param legCounter: TextView object of the current players legCounter that should be updated in case of a win
     */
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

    /**
     * resetScores() method is responsible for resetting the scoreBoards and current scores of both players
     * Called when there's a winner in a leg.
     */
    public void resetScores(){
        scorePlayerOne.setText(String.valueOf(startingScore));
        scorePlayerTwo.setText(String.valueOf(startingScore));
        scoreBoardPlayerOne.clearScores();
        scoreBoardPlayerTwo.clearScores();
        scoreBoardPlayerOne.clearScoreBoard();
        scoreBoardPlayerTwo.clearScoreBoard();
    }

    /**
     * legCounterUpdate() method is responsible for incrementing the legCounter of the winning player by 1
     * Called when there's a winner in a leg.
     * @param legCounter: TextView object of the legCounter for the current player that should be updated.
     */
    public void legCounterUpdate(TextView legCounter){
        int currentCount = Integer.parseInt(legCounter.getText().toString());
        legCounter.setText(String.valueOf(currentCount + 1));
    }

    /**
     * playerRoundSwitcher() method is responsible for tracking the changes between players during rounds.
     */
    public void playerRoundSwitcher(){
        playerRoundSwitch = !playerRoundSwitch;
    }

    /**
     * playerLegSwitcher() method is responsible for tracking the changes between players during legs.
     */
    public void playerLegSwitcher(){
        playerLegSwitch = !playerLegSwitch;
    }

    /**
     * Setter method for field: playerRoundSwitch.
     */
    public void setPlayerRoundSwitch(boolean playerRoundSwitch) {
        this.playerRoundSwitch = playerRoundSwitch;
    }

}
