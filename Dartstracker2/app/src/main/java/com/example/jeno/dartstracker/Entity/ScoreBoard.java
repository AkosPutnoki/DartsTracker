package com.example.jeno.dartstracker.Entity;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private final int length = 6;
    private TextView scoreBoard;
    private List<Integer> scores;

    public ScoreBoard(TextView scoreBoard) {
        this.scoreBoard = scoreBoard;
        scores = new ArrayList<>();
    }

    public void addToScores(int addable){
        scores.add(addable);
    }

    public int getScoresSize(){
        return scores.size();
    }

    public int getLastScore(){
        return scores.get(scores.size() - 1);
    }

    public void removeLast(){
        scores.remove(scores.size() - 1);
    }

    public void clearScores(){
        scores.clear();
    }

    public void clearScoreBoard(){
        this.scoreBoard.setText("");
    }

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
