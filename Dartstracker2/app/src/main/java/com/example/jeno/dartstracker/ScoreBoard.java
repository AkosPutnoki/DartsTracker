package com.example.jeno.dartstracker;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeno on 2018. 02. 19..
 */

public class ScoreBoard {

    /**
     * length: Determines how many scores should be displayed on the scoreBoard
     * scoreBoard: The TextView object that comes from our UI and relates to our ScoreBoard object
     * scores: The list of previous scores stored in the scoreBoard
     */
    private final int length = 5;
    private TextView scoreBoard;
    private List<Integer> scores;

    /**
     * Constructor for class ScoreBoard.
     * Sets scores as a new ArrayList.
     * */
    public ScoreBoard(TextView scoreBoard) {
        this.scoreBoard = scoreBoard;
        scores = new ArrayList<>();
    }

    /**
     * addToScores() method for adding elements to our ScoreBoard objects scores list
     * */
    public void addToScores(int addable){
        scores.add(addable);
    }

    /**
     * Cleares the scores list. Called whenever a leg is over.
     * */
    public void clearScores(){
        scores.clear();
    }


    /**
     * Clears the scoreBoard TextView object. Called whenever a leg is over.
     * */
    public void clearScoreBoard(){
        this.scoreBoard.setText("");
    }

    /**
     * Responsible for rebuilding the scoreBoard TextView object at every change to the scoreBoard.
     * Also makes sure we only show the last *length* amount of scores.
     * */
    public void buildScoreBoard(){
        this.clearScoreBoard();
        if (scores.size() < length){
            for (Integer score: scores){
                scoreBoard.append(String.valueOf(score) + "\n");
            }
        } else {
            for (int i = scores.size() - length; i < scores.size(); i++){
                scoreBoard.append(String.valueOf(scores.get(i)) + "\n");
            }
        }
    }
}
