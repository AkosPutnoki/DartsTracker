package com.example.jeno.dartstracker;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeno on 2018. 02. 19..
 */

public class ScoreBoard {

    private final int length = 5;
    private TextView scoreBoard;
    private List<Integer> scores;

    public ScoreBoard(TextView scoreBoard) {
        this.scoreBoard = scoreBoard;
        scores = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }

    public TextView getScoreBoard() {
        return scoreBoard;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void addToScores(int addable){
        scores.add(addable);
    }

    public void clearScores(){
        scores.clear();
    }

    public void clearScoreBoard(){
        this.scoreBoard.setText("");
    }

    public void buildScoreBoard(){
        this.clearScoreBoard();
        List<Integer> scores = this.getScores();
        TextView scoreBoard = this.getScoreBoard();
        Integer length = this.getLength();
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
